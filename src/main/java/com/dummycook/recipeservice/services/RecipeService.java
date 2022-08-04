package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.entities.Ingredient;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.entities.RecipeIngredient;
import com.dummycook.recipeservice.repositories.RecipeIngredientRepository;
import com.dummycook.recipeservice.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    public List<Recipe> listAll() {
        return recipeRepository.findAll();
    }

    public List<Recipe> listVegetarianRecipes(List<Ingredient> ingredients) {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes.stream()
                .filter(recipe -> !recipe.getRecipeIngredients().isEmpty())
                .filter(recipe -> recipeIngredientsAreVegetarian(recipe))
                .collect(Collectors.toList());
    }

    private boolean recipeIngredientsAreVegetarian(Recipe recipe) {
        return recipe.getRecipeIngredients().stream()
                .allMatch(recipeIngredient -> !recipeIngredient.getRecipeIngredientId().getIngredient().getIsMeat());
    }

    @Transactional
    public Recipe saveRecipe(Recipe recipe){
        Set<RecipeIngredient> ingredientSet = recipe.getRecipeIngredients();
        recipe.setRecipeIngredients(null);
        Recipe savedRecipe = recipeRepository.save(recipe);
        ingredientSet.stream().forEach(recipeIngredient -> {
            recipeIngredient.getRecipeIngredientId().setRecipe(savedRecipe);
            recipeIngredientRepository.save(recipeIngredient);
        });
        return savedRecipe;
    }
}
