package com.dummycook.recipeservice.fixture;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeIngredientDto;
import com.dummycook.recipeservice.entities.RecipeIngredient;
import com.dummycook.recipeservice.services.RecipeName;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeDtoFixture {

    public RecipeDto generateRecipe(RecipeName name) {
        RecipeDto recipe = new RecipeDto();
        String recipeName = null;
        String instructions = null;
        int numberOfServings = 0;
        Set<RecipeIngredientDto> ingredientSet = new HashSet<>(0);
        switch (name) {
            case SPAGHETTI:
                recipeName = "SPAGHETTI AGLIO E OLIO";
                instructions = "Cook the spaghetti in a generously-salted pot of boiling water until it is just one minute shy of being al dente.\\n Sauté the garlic.  Meanwhile, about 3 minutes after you add the pasta to the boiling water, heat the olive oil in a large sauté pan over medium heat. Add the sliced garlic and crushed red pepper flakes and sauté for 3 to 5 minutes, or until the garlic is lightly golden.\\nToss the pasta in the sauce.  Once the pasta is ready to go, use tongs to transfer the pasta immediately to the sauté pan, along with 1/2 cup of the hot starchy pasta water. Toss the pasta continuously until it is evenly coated in the garlic sauce. If the sauce looks a bit too dry, add in another 1/4 cup of the starchy pasta water.\\nTaste and season. Give the pasta a quick taste add an extra pinch of salt and/or crushed red pepper flakes if needed.\\nServe. Serve immediately while it’s nice and hot, garnished with any toppings that sound good.";
                numberOfServings = 6;
                ingredientSet.add(generateRecipeIngredient(1.0, "kg", "Spaghetti"));
                ingredientSet.add(generateRecipeIngredient(5.0, "g", "Salt"));
                ingredientSet.add(generateRecipeIngredient(100.0, "ml", "Olive oil"));
                ingredientSet.add(generateRecipeIngredient(10.0, "g", "Garlic"));
                ingredientSet.add(generateRecipeIngredient(10.0, "g", "Crushed red pepper flakes"));
                break;
            case SALMON:
                recipeName = "SALMON FAJITAS";
                instructions = "In a large bowl or Ziplock bag, combine marinade ingredients. Add the salmon, and toss in the marinade until evenly coated. Cover or seal, and refrigerate for at least 30 minutes, or up to 5 hours.\\n Heat 1 tablespoon olive oil in a large skillet over medium-high heat. Add peppers, onion and jalapeno and saute for 5-6 minutes, stirring occasionally, until the onions are soft and the vegetables all begin to slightly brown on the edges. Add the lime juice and saute for an additional minute, then remove from heat.\\n Meanwhile, in a separate skillet, heat 1 tablespoon olive oil over medium-high heat. Add salmon and marinade, and saute for 3-4 minutes, breaking up the salmon occasionally as it cooks with a spoon or spatula. When the edges begin to look slightly crispy and browned, remove from heat.\\n Assemble the fajitas by layering warm tortillas with the salmon, vegetable mixture and desired toppings.";
                numberOfServings = 4;
                ingredientSet.add(generateRecipeIngredient(2.0, "Tbsp", "fresh lime juice"));
                ingredientSet.add(generateRecipeIngredient(2.0, "cloves", "Minced Garlic "));
                ingredientSet.add(generateRecipeIngredient(1.0, "tsp", "Chipotle Powder"));
                ingredientSet.add(generateRecipeIngredient(0.5, "tsp", "Cumin"));
                ingredientSet.add(generateRecipeIngredient(0.25, "tsp", "Salt"));
                ingredientSet.add(generateRecipeIngredient(0.25, "tsp", "black pepper"));
                ingredientSet.add(generateRecipeIngredient(1.0, "kg", "Salmon"));
                ingredientSet.add(generateRecipeIngredient(2.0, "Tbsp", "olive oil"));
                ingredientSet.add(generateRecipeIngredient(20.0, "g", "Sliced Red Peppers"));
                ingredientSet.add(generateRecipeIngredient(50.0, "g", "Sliced Red Onion"));
                ingredientSet.add(generateRecipeIngredient(50.0, "g", "Diced jalapeno"));
                ingredientSet.add(generateRecipeIngredient(1.0, "Tbsp", "Lime Juice"));
                ingredientSet.add(generateRecipeIngredient(250.0, "g", "warm tortillas"));
                break;
            case BRUSCHETTA:
                recipeName = "BRUSCHETTA";
                instructions = "Prep the tomato topping. Stir together the diced tomatoes, basil, red onion, olive oil and a pinch of salt together in a mixing bowl until evenly combined. Cover and refrigerate for at least 15 minutes or up to 24 hours.\\n Toast the bread. Heat oven to 400°F. Arrange the bread slices on a large baking sheet in an even layer. If you would like, brush the bread lightly with olive oil (or you can skip this step). Bake for 7 to 10 minutes — keeping a close eye on the bread so that it doesn’t over bake — until it is toasted and crispy. Transfer baking sheet to a wire cooling rack.\\n Add garlic. Slice off the ends of the garlic cloves (without removing the papery skins). Then rub the cut end of the garlic evenly over the tops of the bread slices to add as much or as little garlic flavor as you prefer, to taste.\\n Assemble. Taste the tomato topping and season with additional salt (and black pepper, if you’d like) to taste. Sprinkle the grated mozzarella on the top. Add a spoonful of the tomato topping mixture to each slice of bread, then drizzle a hint of olive oil over the tomato topping.\\n Serve. Serve immediately and enjoy!";
                numberOfServings = 16;
                ingredientSet.add(generateRecipeIngredient(1.0, "kg", "diced tomato"));
                ingredientSet.add(generateRecipeIngredient(0.5, "cup", "chopped basil leaves"));
                ingredientSet.add(generateRecipeIngredient(0.3, "cup", "Diced red onion"));
                ingredientSet.add(generateRecipeIngredient(2.0, "tbsp", "Olive oil"));
                ingredientSet.add(generateRecipeIngredient(10.0, "g", "Salt"));
                ingredientSet.add(generateRecipeIngredient(10.0, "g", "Black Pepper"));
                ingredientSet.add(generateRecipeIngredient(25.0, "cm", "large baguette"));
                ingredientSet.add(generateRecipeIngredient(2.0, "cloves", "garlic"));
                ingredientSet.add(generateRecipeIngredient(100.0, "g", "mozzarella cheese"));
                break;
        }

        recipe.setRecipeIngredients(ingredientSet);
        recipe.setName(recipeName);
        recipe.setInstructions(instructions);
        recipe.setNumber_of_servings(numberOfServings);
        return recipe;
    }

    RecipeIngredientDto generateRecipeIngredient(Double amount, String unityOfMeasure, String ingredientName) {
        RecipeIngredientDto recipeIngredient = new RecipeIngredientDto();
        recipeIngredient.setAmount(amount);
        recipeIngredient.setIngredientName(ingredientName);
        recipeIngredient.setUnityOfMeasure(unityOfMeasure);
        return recipeIngredient;
    }

    void processIsMeatIngredients(Set<RecipeIngredient> recipeIngredients) {
        recipeIngredients.stream().forEach(recipeIngredient -> {
            if (recipeIngredient.getRecipeIngredientId().getIngredient().getName().equalsIgnoreCase("Salmon")) {
                recipeIngredient.getRecipeIngredientId().getIngredient().setIsMeat(true);
            }
        });
    }

    void processIsAnimalOriginatedIngredients(Set<RecipeIngredient> recipeIngredients) {
        recipeIngredients.stream().forEach(recipeIngredient -> {
            if (recipeIngredient.getRecipeIngredientId().getIngredient().getName().equalsIgnoreCase("mozzarella cheese")) {
                recipeIngredient.getRecipeIngredientId().getIngredient().setIsAnimalOriginated(true);
            }
        });
    }
}

