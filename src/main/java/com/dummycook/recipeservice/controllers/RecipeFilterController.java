package com.dummycook.recipeservice.controllers;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.services.RecipeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RecipeFilter")
public class RecipeFilterController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/listVegetarianRecipes")
    @ApiOperation(value = "Finds all recipes that are vegetarian",
            notes = "It is also possible to specify a list of ingredients that must be part of the recipe",
            response = List.class)
    public List<Recipe> listVegetarianRecipes(@RequestParam(required = false) Boolean isVegetarian,
                                              @RequestParam(required = false) Boolean isVegan,
                                              @RequestParam(required = false) Integer numberOfServing,
                                              @RequestParam(required = false) String instructionKeyword,
                                              @RequestParam(required = false) List<String> includesIngredientNameList,
                                              @RequestParam(required = false) List<String> excludesIngredientNameList) {
        return recipeService.filter(isVegetarian, isVegan, numberOfServing, instructionKeyword, includesIngredientNameList, excludesIngredientNameList);
    }

    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.saveRecipe(recipeDto);
    }

}
