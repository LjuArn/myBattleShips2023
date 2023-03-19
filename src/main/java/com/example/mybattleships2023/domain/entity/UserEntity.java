package com.example.mybattleships2023.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
}


//•	Username
//o	The length of the values should be between 3 and 10 characters long (both numbers are INCLUSIVE)
//o	The values should be unique in the database
//•	Full Name
//o	The length of the values should be between 5 and 20 characters long (both numbers are INCLUSIVE)
//•	Password
//o	The length of the values should be more than 3 characters long (INCLUSIVE)
//•	Email
//o	The values should contain a '@' symbol
//o	The values should be unique in the database