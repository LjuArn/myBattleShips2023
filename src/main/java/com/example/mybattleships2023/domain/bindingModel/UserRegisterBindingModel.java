package com.example.mybattleships2023.domain.bindingModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class UserRegisterBindingModel {

    @NotBlank(message = "username can not be empty")
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters")
    private String username;

    @NotBlank(message = "email can not be empty")
    @Length(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters")
    private String fullName;

    @Email
    @NotBlank(message = "email can not be empty")
    private String email;

    @NotBlank(message = "password can not be empty")
    @Size(min = 3, message = "Password length must be more than 3 characters")
    private String password;

    @Size(min = 3, message = "Password length must be more than 3 characters")
    private String confirmPassword;


    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
