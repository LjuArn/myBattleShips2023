package com.example.mybattleships2023.domain.serviceModel;

import com.example.mybattleships2023.domain.entity.CategoryEntity;
import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;

import java.time.LocalDate;

public class ShipAddServiceModel {

    private Long id;
    private String name;
    private long power;
    private long health;
    private LocalDate created;
    private CategoryNameEnum category;

    public ShipAddServiceModel() {
    }


    public Long getId() {
        return id;
    }

    public ShipAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipAddServiceModel setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipAddServiceModel setHealth(long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddServiceModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
