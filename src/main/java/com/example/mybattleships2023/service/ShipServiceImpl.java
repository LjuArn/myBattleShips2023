package com.example.mybattleships2023.service;


import com.example.mybattleships2023.domain.bindingModel.ShipAddBindingModel;
import com.example.mybattleships2023.domain.entity.ShipEntity;
import com.example.mybattleships2023.domain.entity.UserEntity;
import com.example.mybattleships2023.domain.serviceModel.ShipAddServiceModel;
import com.example.mybattleships2023.domain.viewModel.ShipView;
import com.example.mybattleships2023.repository.ShipRepository;
import com.example.mybattleships2023.repository.UserRepository;
import com.example.mybattleships2023.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    public ShipServiceImpl(ShipRepository shipRepository,
                           CategoryService categoryService,
                           ModelMapper modelMapper,
                           CurrentUser currentUser, UserRepository userRepository) {
        this.shipRepository = shipRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }


    @Override
    public void addShip(ShipAddServiceModel shipAddServiceModel) {

        UserEntity owner = userRepository.findById(currentUser.getId()).orElse(null);

        ShipEntity ship = modelMapper.map(shipAddServiceModel, ShipEntity.class);

        ship.setCategory(categoryService.findByCategoryNameEnum(shipAddServiceModel.getCategory()));
        ship.setUser(owner);

        shipRepository.saveAndFlush(ship);
    }

    @Override
    public boolean existShip(ShipAddBindingModel shipAddBindingModel) {

        Optional<ShipEntity> ExShipByName = shipRepository.findByName(shipAddBindingModel.getName());

        return ExShipByName.isPresent();
    }

    @Override
    public List<ShipView> getShipsOwnedBy(Long ownerId) {
        return shipRepository.findAllByUser_Id(ownerId)
                .stream()
                .map(shipEntity-> modelMapper.map(shipEntity, ShipView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipView> getEnemyShips(Long curUserId) {
        return shipRepository.findAllByUser_IdNot(curUserId)
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity,ShipView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipView> getAllSortedShips() {
        return shipRepository.findAllByOrderByNameAscHealthAscPowerAsc()
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipView.class))
                .collect(Collectors.toList());
    }


}

