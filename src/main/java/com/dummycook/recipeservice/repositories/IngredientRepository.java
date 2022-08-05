package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query("select i from Ingredient i where lower(i.name) = lower(?1)")
    Optional<Ingredient> findByName(String name);
}