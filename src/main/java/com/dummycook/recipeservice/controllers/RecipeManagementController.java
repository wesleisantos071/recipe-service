package com.dummycook.recipeservice.controllers;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.services.RecipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "RecipeManagement")
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

    @ApiOperation(value = "Save a recipe based on the RecipeDto object provided",
            notes = "It is recommended to use ingredients already existing in DB (use GET api /api/data/ingredients) " +
                    "so the isMeat and isAnimalOriginated attributes are filled properly. " +
                    "\nIt is possible to provide ingredient names not yet existing in DB when calling this endopoint, " +
                    "however the attributes isMeat and isAnimalOriginated will have a default value of false",
            response = List.class)
    @PostMapping("/saveRecipe")
    public Recipe saveRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.saveRecipe(recipeDto);
    }

    @GetMapping("/findByName")
    public Recipe findByName(String recipeName) {
        return recipeService.findByName(recipeName);
    }

    @DeleteMapping("/deleteById")
    public Boolean deleteById(Long id) {
        return recipeService.deleteById(id);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an existing recipe",
            notes = "Update a recipe based on the RecipeDto object provided" +
                    "\nImportant: the name of the recipe cannot be changed",
            response = List.class)
    public void updateRecipe(@RequestParam long id, @RequestBody RecipeDto recipeDto) {
        recipeService.updateRecipe(id, recipeDto);
    }
}
