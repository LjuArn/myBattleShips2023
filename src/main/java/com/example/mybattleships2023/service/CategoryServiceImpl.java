package com.example.mybattleships2023.service;

import com.example.mybattleships2023.domain.entity.CategoryEntity;
import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;
import com.example.mybattleships2023.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {


    public final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {


        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity category = new CategoryEntity(categoryNameEnum,
                            "Description " + categoryNameEnum.name());

                    categoryRepository.save(category);
                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByNameEnum(categoryNameEnum).orElse(null);
    }


}

