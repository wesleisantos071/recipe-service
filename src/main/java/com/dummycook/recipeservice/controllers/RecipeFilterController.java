package com.dummycook.recipeservice.controllers;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeDtoMapper;
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

    @Autowired
    RecipeDtoMapper recipeDtoMapper;

    @GetMapping("/listVegetarianRecipes")
    @ApiOperation(value = "Finds all recipes that are vegetarian",
            notes = "It is also possible to specify a list of ingredients that must be part of the recipe",
            response = List.class)
    public List<Recipe> listVegetarianRecipes(@RequestParam(required = false) List<Long> ingredientIdList) {
        return recipeService.listVegetarianRecipes(ingredientIdList);
    }

    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeDtoMapper.convertDtoToEntity(recipeDto);
        return recipeService.saveRecipe(recipe);
    }

}
