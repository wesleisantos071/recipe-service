package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeIngredientDto;
import com.dummycook.recipeservice.entities.Recipe;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Autowired
    DataFixture fixture;

    Recipe spaghetti;
    Recipe salmon;
    Recipe bruschetta;

    @BeforeEach
    void setUp() {
        //Vegetarian/vegan recipe
        RecipeDto recipeSpaghettiDto = fixture.generateRecipe("SPAGHETTI AGLIO E OLIO"
                , "Cook the spaghetti in a generously-salted pot of boiling water until it is just one minute shy of being al dente.\\n Sauté the garlic.  Meanwhile, about 3 minutes after you add the pasta to the boiling water, heat the olive oil in a large sauté pan over medium heat. Add the sliced garlic and crushed red pepper flakes and sauté for 3 to 5 minutes, or until the garlic is lightly golden.\\nToss the pasta in the sauce.  Once the pasta is ready to go, use tongs to transfer the pasta immediately to the sauté pan, along with 1/2 cup of the hot starchy pasta water. Toss the pasta continuously until it is evenly coated in the garlic sauce. If the sauce looks a bit too dry, add in another 1/4 cup of the starchy pasta water.\\nTaste and season. Give the pasta a quick taste add an extra pinch of salt and/or crushed red pepper flakes if needed.\\nServe. Serve immediately while it’s nice and hot, garnished with any toppings that sound good."
                , 6);
        Set<RecipeIngredientDto> ingredientSet = new HashSet<>(0);
        ingredientSet.add(fixture.generateRecipeIngredient(recipeSpaghettiDto, 1.0, "kg", "Spaghetti"));
        ingredientSet.add(fixture.generateRecipeIngredient(recipeSpaghettiDto, 5.0, "g", "Salt"));
        ingredientSet.add(fixture.generateRecipeIngredient(recipeSpaghettiDto, 100.0, "ml", "Olive oil"));
        ingredientSet.add(fixture.generateRecipeIngredient(recipeSpaghettiDto, 10.0, "g", "Garlic"));
        ingredientSet.add(fixture.generateRecipeIngredient(recipeSpaghettiDto, 10.0, "g", "Crushed red pepper flakes"));
        recipeSpaghettiDto.setRecipeIngredients(ingredientSet);
        spaghetti = recipeService.saveRecipe(recipeSpaghettiDto);
        //Non vegetarian recipe
        RecipeDto recipeSalmonDto = fixture.generateRecipe("SALMON FAJITAS"
                , "In a large bowl or Ziplock bag, combine marinade ingredients. Add the salmon, and toss in the marinade until evenly coated. Cover or seal, and refrigerate for at least 30 minutes, or up to 5 hours.\\n Heat 1 tablespoon olive oil in a large skillet over medium-high heat. Add peppers, onion and jalapeno and saute for 5-6 minutes, stirring occasionally, until the onions are soft and the vegetables all begin to slightly brown on the edges. Add the lime juice and saute for an additional minute, then remove from heat.\\n Meanwhile, in a separate skillet, heat 1 tablespoon olive oil over medium-high heat. Add salmon and marinade, and saute for 3-4 minutes, breaking up the salmon occasionally as it cooks with a spoon or spatula. When the edges begin to look slightly crispy and browned, remove from heat.\\n Assemble the fajitas by layering warm tortillas with the salmon, vegetable mixture and desired toppings."
                , 4);
        Set<RecipeIngredientDto> ingredientSet2 = new HashSet<>(0);
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 2.0, "Tbsp", "fresh lime juice"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 2.0, "cloves", "Minced Garlic "));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 1.0, "tsp", "Chipotle Powder"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 0.5, "tsp", "Cumin"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 0.25, "tsp", "Salt"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 0.25, "tsp", "black pepper"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 1.0, "kg", "Salmon"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 2.0, "Tbsp", "olive oil"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 20.0, "g", "Sliced Red Peppers"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 50.0, "g", "Sliced Red Onion"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 50.0, "g", "Diced jalapeno"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 1.0, "Tbsp", "Lime Juice"));
        ingredientSet2.add(fixture.generateRecipeIngredient(recipeSalmonDto, 250.0, "g", "warm tortillas"));
        recipeSalmonDto.setRecipeIngredients(ingredientSet2);
        salmon = recipeService.saveRecipe(recipeSalmonDto);
        //Non vegan recipe
        RecipeDto recipeBruschettaDto = fixture.generateRecipe("BRUSCHETTA"
                , "Prep the tomato topping. Stir together the diced tomatoes, basil, red onion, olive oil and a pinch of salt together in a mixing bowl until evenly combined. Cover and refrigerate for at least 15 minutes or up to 24 hours.\\n Toast the bread. Heat oven to 400°F. Arrange the bread slices on a large baking sheet in an even layer. If you would like, brush the bread lightly with olive oil (or you can skip this step). Bake for 7 to 10 minutes — keeping a close eye on the bread so that it doesn’t over bake — until it is toasted and crispy. Transfer baking sheet to a wire cooling rack.\\n Add garlic. Slice off the ends of the garlic cloves (without removing the papery skins). Then rub the cut end of the garlic evenly over the tops of the bread slices to add as much or as little garlic flavor as you prefer, to taste.\\n Assemble. Taste the tomato topping and season with additional salt (and black pepper, if you’d like) to taste. Add a spoonful of the tomato topping mixture to each slice of bread, then drizzle a hint of olive oil over the tomato topping.\\n Serve. Serve immediately and enjoy!"
                , 16);
        Set<RecipeIngredientDto> ingredientSet3 = new HashSet<>(0);
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 1.0, "kg", "diced tomato"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 0.5, "cup", "chopped fresh basil leaves"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 0.3, "cup", "finely-diced red onion (optional)"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 2.0, "tbsp", "extra-virgin olive oil, plus extra for brushing/drizzling"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 10.0, "g", "Salt"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 10.0, "g", "Black Pepper"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 25.0, "cm", "large baguette"));
        ingredientSet3.add(fixture.generateRecipeIngredient(recipeBruschettaDto, 2.0, "cloves", "garlic"));
        recipeBruschettaDto.setRecipeIngredients(ingredientSet3);
        salmon = recipeService.saveRecipe(recipeBruschettaDto);
    }

    //generate a recipe vegetarian and check if the search can find it
    @Test
    void givenVegetarianRecipeSaved_then_FindItOnVegetarianRecipes() {
        List<Recipe> resultingRecipes = recipeService.filter(true, null, null, null, null, null);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == spaghetti.getId()).isTrue();
    }

    //generate a recipe with a number of servings, and check if the search can find it by number of servings
    @Test
    void givenRecipeSaved_then_FindItByNumberOfServings() {
        List<Recipe> resultingRecipes = recipeService.filter(null, null, 4, null, null, null);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == salmon.getId()).isTrue();
    }

    //generate a recipe with certain ingredients and check if the search can find the recipe based on the includingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByIncludedIngredients() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                null,
                includesIngredientNameList,
                null);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == salmon.getId()).isTrue();
    }

    //generate a recipe that does not have salmon as ingredient and check if the search can find the recipe based on the excludingIngredientList
    @Test
    void givenRecipeSaved_then_FindItByExcludedIngredients() {
        List<String> excludesIngredientNameList = new ArrayList<>();
        excludesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                null,
                null,
                excludesIngredientNameList);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == spaghetti.getId()).isTrue();
    }

    //generate a recipe with certain instructions and check if the search can find the recipe based on the instructions keywords list
    @Test
    void givenRecipeSaved_then_FindItByInstructionsContainingKeywords() {
        String instructionKeyWord = "crispy";
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                instructionKeyWord,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == salmon.getId()).isTrue();
    }

    //generate a recipe that serves 4 people and have potato as an ingredient and check if the search can find it
    @Test
    void givenRecipeSaved_then_FindItBasedOnNumberOfServingsAndIncludedIngredients() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                4,
                null,
                includesIngredientNameList,
                null);
        Assertions.assertThat(resultingRecipes.size() == 1).isTrue();
        Assertions.assertThat(resultingRecipes.get(0).getId() == salmon.getId()).isTrue();
    }

    //generate a recipe that does not have salmon as ingredient, and the word 'oven' in the instructions and check if the search can find it based on the excludingIngredientList, and instructions keyword
    @Test
    void givenRecipeSaved_then_FindItBasedOnMultipleCriteria() {

    }
}