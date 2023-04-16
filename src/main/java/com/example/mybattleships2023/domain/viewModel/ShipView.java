package com.example.mybattleships2023.domain.viewModel;

import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipView {

    private Long id;
    private String name;
    private long power;
    private long health;

    public ShipView() {
    }

    public ShipView(Long id, String name, long power, long health) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.health = health;
    }

    public Long getId() {
        return id;
    }

    public ShipView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipView setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipView setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipView setHealth(long health) {
        this.health = health;
        return this;
    }
}
