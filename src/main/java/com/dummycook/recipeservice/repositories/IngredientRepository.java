package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}