package com.example.mybattleships2023.repository;

import com.example.mybattleships2023.domain.entity.CategoryEntity;
import com.example.mybattleships2023.domain.entity.enums.CategoryNameEnum;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

Optional<CategoryEntity> findByNameEnum(CategoryNameEnum nameEnum);

}
