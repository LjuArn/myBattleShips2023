package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.entity.ShipEntity;
import com.example.mybattleships2023.domain.viewModel.StartBattleView;
import com.example.mybattleships2023.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ButtleServiceImpl implements ButtleService {

    private final ShipRepository shipRepository;

    public ButtleServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public void attack(StartBattleView startBattleView) {

        Optional<ShipEntity> attackerOpt = shipRepository.findById(startBattleView.getAttackerId());
        Optional<ShipEntity> defenderOpt = shipRepository.findById(startBattleView.getDefenderId());


        ShipEntity attacker = attackerOpt.get();
        ShipEntity defender = defenderOpt.get();

        long newDeffenderHealth = defender.getHealth() - attacker.getHealth();

        if(newDeffenderHealth <=0){
            shipRepository.delete(defender);
        }else {
            defender.setHealth(newDeffenderHealth);
            shipRepository.save(defender);
        }
    }
}
