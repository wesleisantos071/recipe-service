package com.dummycook.recipeservice.controllers;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.services.RecipeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RecipeManagement")
public class RecipeManagementController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("list")
    public List<Recipe> list() {
        return recipeService.listAll();
    }

    @GetMapping("/search")
    @ApiOperation(value = "Searches recipes based on provided filters",
            notes = "All filters are optional, and can be used individually or combined",
            response = List.class)
    public List<Recipe> search(@RequestParam(required = false) Boolean isVegetarian,
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

    @GetMapping("/findByName")
    public Recipe findByName(@RequestParam(required = true) String recipeName) {
        return recipeService.findByName(recipeName);
    }

    @DeleteMapping("/deleteById")
    public Boolean deleteById(@RequestParam(required = true) Long id) {
        return recipeService.deleteById(id);
    }

    @PostMapping("/update")
    public Recipe updateRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.updateRecipe(recipeDto);
    }

}
