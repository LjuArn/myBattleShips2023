package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.bindingModel.ShipAddBindingModel;
import com.example.mybattleships2023.domain.serviceModel.ShipAddServiceModel;
import com.example.mybattleships2023.domain.viewModel.ShipView;

import java.util.List;

public interface ShipService {
    void addShip(ShipAddServiceModel shipAddServiceModel);


    boolean existShip(ShipAddBindingModel shipAddBindingModel);


    List<ShipView> getShipsOwnedBy(Long id);

    List<ShipView> getEnemyShips(Long curUserId);


    List<ShipView> getAllSortedShips();
}
