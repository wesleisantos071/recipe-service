package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByName(String name);
}