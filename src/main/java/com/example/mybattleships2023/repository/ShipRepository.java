package com.example.mybattleships2023.repository;

import com.example.mybattleships2023.domain.entity.ShipEntity;
import com.example.mybattleships2023.domain.viewModel.ShipView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {

    Optional<ShipEntity> findByName(String name);

    List<ShipEntity> findAllByUser_Id(Long ownerId);

    List<ShipEntity> findAllByUser_IdNot(Long user_id);


    List<ShipEntity> findAllByOrderByNameAscHealthAscPowerAsc();


}
