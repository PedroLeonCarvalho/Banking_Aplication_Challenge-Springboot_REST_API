package com.desafio.PCPY.domain.users;

import com.desafio.PCPY.dtos.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private BigDecimal balance;

    public User(UserDto data) {

        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.document = data.document();
        this.userType = data.userType();
        this.password = data.password();
        this.email= data.email();
    }
}
