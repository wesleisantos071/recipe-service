package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.RecipeIngredient;
import com.dummycook.recipeservice.entities.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
}