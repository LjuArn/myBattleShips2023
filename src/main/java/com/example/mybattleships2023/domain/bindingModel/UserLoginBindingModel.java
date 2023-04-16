package com.example.mybattleships2023.domain.bindingModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotBlank
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters!!!!!!")
    private String username;


    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters!!!!!!!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
