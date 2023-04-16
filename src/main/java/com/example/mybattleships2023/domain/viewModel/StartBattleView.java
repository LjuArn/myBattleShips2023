package com.example.mybattleships2023.domain.viewModel;

import jakarta.validation.constraints.Positive;

public class StartBattleView {

    @Positive
    private long attackerId;
    @Positive
    private long defenderId;

    public StartBattleView() {
    }

    public long getAttackerId() {
        return attackerId;
    }

    public StartBattleView setAttackerId(long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public long getDefenderId() {
        return defenderId;
    }

    public StartBattleView setDefenderId(long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
