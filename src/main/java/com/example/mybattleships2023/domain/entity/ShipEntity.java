package com.example.mybattleships2023.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class ShipEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    @Positive
    private long health;
    @Column(nullable = false)
    @Positive
    private long power;
    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ShipEntity() {
    }

    public String getName() {
        return name;
    }

    public ShipEntity setName(String name) {
        this.name = name;
        return this;
    }

    public long getHealth() {
        return health;
    }

    public ShipEntity setHealth(long health) {
        this.health = health;
        return this;
    }

    public long getPower() {
        return power;
    }

    public ShipEntity setPower(long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipEntity setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ShipEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public ShipEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
