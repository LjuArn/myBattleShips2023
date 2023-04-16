package com.example.mybattleships2023.domain.bindingModel;

import com.example.mybattleships2023.domain.entity.CategoryEntity;
import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ShipAddBindingModel {

    @NotBlank
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    private String name;

    @Positive(message = "The power must be positive.")
    private long power;

    @Positive(message = "The health must be positive!")
    private long health;

    @PastOrPresent(message = "Created date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull(message = "Enter valid category")
    private CategoryNameEnum category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(long power) {
        this.power = power;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
