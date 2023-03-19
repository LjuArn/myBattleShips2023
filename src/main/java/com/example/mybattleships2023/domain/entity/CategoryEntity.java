package com.example.mybattleships2023.domain.entity;


import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum nameEnum;
    @Column(name = "description",  nullable = true, columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryNameEnum nameEnum, String description) {
        this.nameEnum = nameEnum;
        this.description = description;
    }

    public CategoryNameEnum getNameEnum() {
        return nameEnum;
    }

    public CategoryEntity setNameEnum(CategoryNameEnum nameEnum) {
        this.nameEnum = nameEnum;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
