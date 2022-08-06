package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByName(String name);

}