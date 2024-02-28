package com.desafio.PCPY.domain.users;

import com.desafio.PCPY.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    public Optional<User> findUserByDocument(String document);

    public Optional<User> findUserById(Long id);



}



