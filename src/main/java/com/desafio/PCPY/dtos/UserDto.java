package com.desafio.PCPY.dtos;

import com.desafio.PCPY.domain.users.UserType;

import java.math.BigDecimal;

public record UserDto(
        String firstName,
        String lastName,
        String document,
        BigDecimal balance,
        String email,
        String password,
        UserType userType
) {

}
