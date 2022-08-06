package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.controllers.RecipeManagementController;
import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.entities.Recipe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RecipeServiceTestIT {

    @Autowired
    private RecipeManagementController controller;

    @Autowired
    DataFixture fixture;

    Recipe spaghetti;
    Recipe salmon;
    Recipe bruschetta;

    String SPAGHETTI_TITLE = "SPAGHETTI AGLIO E OLIO";
    String SALMON_TITLE = "SALMON FAJITAS";
    String BRUSCHETTA_TITLE = "BRUSCHETTA";

    @BeforeEach
    void setUp() {
        //Vegetarian/vegan recipe
        spaghetti = getOrCreateRecipe(SPAGHETTI_TITLE);
        //Non vegetarian recipe
        salmon = getOrCreateRecipe(SALMON_TITLE);
        //Non vegan recipe
        bruschetta = getOrCreateRecipe(BRUSCHETTA_TITLE);
    }

    private Recipe getOrCreateRecipe(String name) {
        Recipe recipe = controller.findByName(name);
        if (recipe != null) {
            return recipe;
        }
        if (SPAGHETTI_TITLE.equals(name)) {
            RecipeDto recipeSpaghettiDto = fixture.generateRecipe(RecipeName.SPAGHETTI);
            return controller.saveRecipe(recipeSpaghettiDto);
        }
        if (SALMON_TITLE.equals(name)) {
            RecipeDto recipeSalmonDto = fixture.generateRecipe(RecipeName.SALMON);
            return controller.saveRecipe(recipeSalmonDto);
        }
        if (BRUSCHETTA_TITLE.equals(name)) {
            RecipeDto recipeBruschettaDto = fixture.generateRecipe(RecipeName.BRUSCHETTA);
            return controller.saveRecipe(recipeBruschettaDto);
        }
        return null;
    }

    //generate a recipe vegetarian and check if the search can find it
    @Test
    void givenVegetarianRecipeSaved_then_FindItOnVegetarianRecipes() {
        List<Recipe> resultingRecipes = controller.search(true, null, null, null, null, null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == spaghetti.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    //generate a recipe with a number of servings, and check if the search can find it by number of servings
    @Test
    void givenRecipeSaved_then_FindItByNumberOfServings() {
        List<Recipe> resultingRecipes = controller.search(null, null, 4, null, null, null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(salmon.getId());
    }

    //generate a recipe with certain ingredients and check if the search can find the recipe based on the includingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByIncludedIngredients() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = controller.search(null,
                null,
                null,
                null,
                includesIngredientNameList,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(salmon.getId());
    }

    //generate a recipe that does not have salmon as ingredient and check if the search can find the recipe based on the excludingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByExcludedIngredients() {
        List<String> excludesIngredientNameList = new ArrayList<>();
        excludesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = controller.search(null,
                null,
                null,
                null,
                null,
                excludesIngredientNameList);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == spaghetti.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    //generate a recipe with certain instructions and check if the search can find the recipe based on the instructions keywords list
    @Test
    void givenRecipeSaved_then_FindItByInstructionsContainingKeywords() {
        String instructionKeyWord = "crispy";
        List<Recipe> resultingRecipes = controller.search(null,
                null,
                null,
                instructionKeyWord,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == salmon.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    //generate a recipe that serves 4 people and have potato as an ingredient and check if the search can find it
    @Test
    void givenRecipeSaved_then_FindItBasedOnNumberOfServingsAndIncludedIngredients() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = controller.search(null,
                null,
                4,
                null,
                includesIngredientNameList,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(salmon.getId());
    }

    //generate a recipe that
    // - does not have salmon as ingredient
    // and
    // - the word 'oven' in the instructions
    // then check if the search can find it based on the excludingIngredientList, and instructions keyword
    @Test
    void givenRecipeSaved_then_FindItBasedOnMultipleCriteria() {
        List<String> excludesIngredientNameList = new ArrayList<>();
        excludesIngredientNameList.add("Salmon");
        String instructionKeyword = "crispy";
        List<Recipe> resultingRecipes = controller.search(null,
                null,
                null,
                instructionKeyword,
                null,
                excludesIngredientNameList);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(bruschetta.getId());
    }
}