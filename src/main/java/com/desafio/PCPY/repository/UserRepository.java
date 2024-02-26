package com.desafio.PCPY.repository;

import com.desafio.PCPY.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    public Optional<User> findUserByDocument(String document);

    public Optional<User> findUserById(Long id);



}



