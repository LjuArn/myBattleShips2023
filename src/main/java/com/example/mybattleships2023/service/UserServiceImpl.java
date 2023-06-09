package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.entity.UserEntity;
import com.example.mybattleships2023.domain.serviceModel.UserServiceModel;
import com.example.mybattleships2023.repository.UserRepository;
import com.example.mybattleships2023.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserServiceImpl implements UserService {

   private  final UserRepository userRepository;
   private final ModelMapper modelMapper;
    private final  CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {

        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setId(id).setUsername(username);
    }

    @Override
    public void logOut() {
        currentUser.setId(null).setUsername(null);
    }


    //_________________________________________________________________________________

}
