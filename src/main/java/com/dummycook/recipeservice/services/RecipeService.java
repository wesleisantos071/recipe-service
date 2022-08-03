package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.entities.Ingredient;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> listAll() {
        return recipeRepository.findAll();
    }

    public List<Recipe> listVegetarianRecipes(List<Ingredient> ingredients) {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes.stream()
                .filter(recipe -> !recipe.getRecipeIngredients().isEmpty())
                .filter(recipe -> recipe.getRecipeIngredients().stream().findFirst().get().getIngredient().getIsMeat())
                .collect(Collectors.toList());
    }
}
