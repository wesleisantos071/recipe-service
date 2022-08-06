package com.dummycook.recipeservice.dto;

import com.dummycook.recipeservice.entities.*;
import com.dummycook.recipeservice.repositories.IngredientRepository;
import com.dummycook.recipeservice.repositories.TypeOfUnityRepository;
import com.dummycook.recipeservice.repositories.UnityOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class RecipeDtoMapper {

    IngredientRepository ingredientRepository;

    UnityOfMeasureRepository unityOfMeasureRepository;

    TypeOfUnityRepository typeOfUnityRepository;

    @Autowired
    public RecipeDtoMapper(IngredientRepository ingredientRepository, UnityOfMeasureRepository unityOfMeasureRepository, TypeOfUnityRepository typeOfUnityRepository) {
        this.ingredientRepository = ingredientRepository;
        this.unityOfMeasureRepository = unityOfMeasureRepository;
        this.typeOfUnityRepository = typeOfUnityRepository;
    }

    public Recipe convertDtoToEntity(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDto.getName());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setNumber_of_servings(recipeDto.getNumber_of_servings());
        recipe.setRecipeIngredients(new HashSet<>());
        recipeDto.getRecipeIngredients().stream().forEach(recipeIngredientDto -> {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setAmount(recipeIngredientDto.getAmount());
            recipeIngredient.setUnityOfMeasure(getUnityOfMeasureByName(recipeIngredientDto.getUnityOfMeasure()));
            RecipeIngredientId id = new RecipeIngredientId();
            id.setRecipe(recipe);
            id.setIngredient(getIngredientByName(recipeIngredientDto.getIngredientName()));
            recipeIngredient.setRecipeIngredientId(id);
            recipe.getRecipeIngredients().add(recipeIngredient);
        });
        return recipe;
    }

    public Ingredient getIngredientByName(String ingredientName) {
        Optional<Ingredient> ingredientInDb = ingredientRepository.findByName(ingredientName);
        Ingredient ingredient;
        if (ingredientInDb.isPresent()) {
            ingredient = ingredientInDb.get();
        } else {
            ingredient = new Ingredient();
            ingredient.setName(ingredientName);
            ingredient.setIsMeat(false);
            ingredient.setIsAnimalOriginated(false);
            ingredient = ingredientRepository.save(ingredient);
        }
        return ingredient;
    }

    public UnityOfMeasure getUnityOfMeasureByName(String unityOfMeasureName) {
        Optional<UnityOfMeasure> unityOfMeasureInDb = unityOfMeasureRepository.findByName(unityOfMeasureName);
        UnityOfMeasure unityOfMeasure;
        if (unityOfMeasureInDb.isPresent()) {
            unityOfMeasure = unityOfMeasureInDb.get();
        } else {
            unityOfMeasure = new UnityOfMeasure();
            unityOfMeasure.setName(unityOfMeasureName);
            unityOfMeasure.setTypeOfUnity(typeOfUnityRepository.findById(0l).orElse(null));//set the default id of unknown type of unity
            unityOfMeasure = unityOfMeasureRepository.save(unityOfMeasure);
        }
        return unityOfMeasure;
    }
}
