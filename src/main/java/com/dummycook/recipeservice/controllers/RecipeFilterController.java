package com.dummycook.recipeservice.controllers;

import com.dummycook.recipeservice.entities.Ingredient;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.repositories.RecipeIngredientRepository;
import com.dummycook.recipeservice.services.RecipeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/RecipeFilter")
public class RecipeFilterController {

    @Autowired
    RecipeService recipeService;



    @GetMapping("/listVegetarianRecipes")
    @ApiOperation(value="Finds all recipes that are vegetarian",
    notes = "It is also possible to specify a list of ingredients that must be part of the recipe, but ingredients non vegetarian wont take any effect on the expected result of this API",
    response = List.class)
    public List<Recipe> listVegetarianRecipes(@RequestBody List<Ingredient> ingredients){
        return recipeService.listVegetarianRecipes(ingredients);
    }

    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

}
