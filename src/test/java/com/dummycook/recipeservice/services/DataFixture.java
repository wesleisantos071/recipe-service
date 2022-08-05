package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeIngredientDto;
import org.springframework.stereotype.Service;

@Service
public class DataFixture {

    RecipeDto generateRecipe(String name, String instructions, int numberOfServings) {
        RecipeDto recipe = new RecipeDto();
        recipe.setName(name);
        recipe.setInstructions(instructions);
        recipe.setNumber_of_servings(numberOfServings);
        return recipe;
    }

    RecipeIngredientDto generateRecipeIngredient(RecipeDto recipe, Double amount, String ingredientName, String unityOfMeasure) {
        RecipeIngredientDto recipeIngredient = new RecipeIngredientDto();
        recipeIngredient.setAmount(amount);
        recipeIngredient.setIngredientName(ingredientName);
        recipeIngredient.setUnityOfMeasure(unityOfMeasure);
        return recipeIngredient;
    }
}
