package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.dto.RecipeDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    DataFixture fixture;

    @BeforeEach
    void setUp() {
    }

    //generate a recipe vegetarian and check if the search can find it
    @Test
    void givenVegetarianRecipeSaved_then_FindItOnVegetarianRecipes() {
        RecipeDto recipeDto = fixture.generateRecipe("SPAGHETTI AGLIO E OLIO"
                , "Cook the spaghetti in a generously-salted pot of boiling water until it is just one minute shy of being al dente.\\n Sauté the garlic.  Meanwhile, about 3 minutes after you add the pasta to the boiling water, heat the olive oil in a large sauté pan over medium heat. Add the sliced garlic and crushed red pepper flakes and sauté for 3 to 5 minutes, or until the garlic is lightly golden.\\nToss the pasta in the sauce.  Once the pasta is ready to go, use tongs to transfer the pasta immediately to the sauté pan, along with 1/2 cup of the hot starchy pasta water. Toss the pasta continuously until it is evenly coated in the garlic sauce. If the sauce looks a bit too dry, add in another 1/4 cup of the starchy pasta water.\\nTaste and season. Give the pasta a quick taste add an extra pinch of salt and/or crushed red pepper flakes if needed.\\nServe. Serve immediately while it’s nice and hot, garnished with any toppings that sound good."
                , 6);
        recipeService.saveRecipe(recipeDto);
        recipeService.filter(true, null, null, null, null);
    }

    //generate a recipe with a number of servings, and check if the search can find it by number of servings
    @Test
    void givenRecipeSaved_then_FindItByNumberOfServings() {

    }

    //generate a recipe with certain ingredients and check if the search can find the recipe based on the includingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByIncludedIngredients() {

    }

    //generate a recipe that does not have salmon as ingredient and check if the search can find the recipe based on the excludingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByExcludedIngredients() {

    }

    //generate a recipe with certain instructions and check if the search can find the recipe based on the instructions keywords list
    @Test
    void givenRecipeSaved_then_FindItByInstructionsContainingKeywords() {

    }

    //generate a recipe that serves 4 people and have potato as an ingredient and check if the search can find it
    @Test
    void givenRecipeSaved_then_FindItBasedOnNumberOfServingsAndIncludedIngredients() {

    }

    //generate a recipe that does not have salmon as ingredient, and the word 'oven' in the instructions and check if the search can find it based on the excludingIngredientList, and instructions keyword
    @Test
    void givenRecipeSaved_then_FindItBasedOnMultipleCriteria() {

    }
}