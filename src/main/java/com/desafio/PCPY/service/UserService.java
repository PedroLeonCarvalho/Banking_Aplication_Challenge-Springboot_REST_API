package com.desafio.PCPY.service;

import com.desafio.PCPY.domain.users.User;
import com.desafio.PCPY.domain.users.UserRepository;
import com.desafio.PCPY.domain.users.UserType;
import com.desafio.PCPY.dtos.UserDto;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction (User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception ("Usuario não atuorizado a realizar transferencia");
        }
            if (sender.getBalance().compareTo(amount) < 0) {
throw new Exception("Saldo insuficiente");
            }
    }

    public User findUserById (Long id) throws Exception {
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));

    }

    public void saveUser (User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDto user) {
        User newUser = new User(user);
        userRepository.save(newUser);
        return newUser;


    }

    public List<User> getAllUsers() {
    return userRepository.findAll();

    }
}
