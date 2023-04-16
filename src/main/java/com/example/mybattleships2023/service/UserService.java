package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.serviceModel.UserServiceModel;

public interface UserService {


    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logOut();
}
