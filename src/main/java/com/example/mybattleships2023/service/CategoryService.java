package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.entity.CategoryEntity;
import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
