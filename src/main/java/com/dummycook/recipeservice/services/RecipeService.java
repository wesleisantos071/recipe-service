package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeDtoMapper;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.entities.RecipeIngredient;
import com.dummycook.recipeservice.repositories.RecipeIngredientRepository;
import com.dummycook.recipeservice.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDtoMapper recipeDtoMapper;

    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    public List<Recipe> listAll() {
        return recipeRepository.findAll();
    }

    public List<Recipe> filter(Boolean isVegetarianFilter,
                               Boolean isVeganFilter,
                               Integer numberOfServing,
                               String instructionKeywordFilter,
                               List<String> includesIngredientNameListFilter,
                               List<String> excludesIngredientNameListFilter) {
        List<Recipe> allRecipes = recipeRepository.findAll();
        return allRecipes.stream()
                .filter(recipe -> !recipe.getRecipeIngredients().isEmpty())
                .filter(recipe -> isVegetarianFilter != null ? areRecipeIngredientsVegetarian(recipe) : true)
                .filter(recipe -> isVeganFilter != null ? areRecipeIngredientsVegan(recipe) : true)
                .filter(recipe -> numberOfServing != null ? recipeMatchesNumberOfServing(recipe, numberOfServing) : true)
                .filter(recipe -> instructionKeywordFilter != null ? recipeMatchesInstructionKeyWord(recipe, instructionKeywordFilter) : true)
                .filter(recipe -> includesIngredientNameListFilter != null ? containsIngredients(recipe, includesIngredientNameListFilter) : true)
                .filter(recipe -> excludesIngredientNameListFilter != null ? doesNotContainIngredients(recipe, excludesIngredientNameListFilter) : true)
                .collect(Collectors.toList());
    }

    private boolean recipeMatchesInstructionKeyWord(Recipe recipe, String instructionKeywordFilter) {
        return recipe.getInstructions().toLowerCase().contains(instructionKeywordFilter.toLowerCase());
    }

    private boolean recipeMatchesNumberOfServing(Recipe recipe, Integer numberOfServing) {
        return recipe.getNumber_of_servings() == numberOfServing;
    }

    private boolean areRecipeIngredientsVegetarian(Recipe recipe) {
        return recipe.getRecipeIngredients().stream()
                .allMatch(recipeIngredient -> !recipeIngredient.getRecipeIngredientId().getIngredient().getIsMeat());
    }

    private boolean areRecipeIngredientsVegan(Recipe recipe) {
        return recipe.getRecipeIngredients().stream()
                .allMatch(recipeIngredient -> !recipeIngredient.getRecipeIngredientId().getIngredient().getIsMeat()
                        & !recipeIngredient.getRecipeIngredientId().getIngredient().getIsAnimalOriginated()
                );
    }

    private boolean containsIngredients(Recipe recipe, List<String> includingIngredientNameList) {
        return includingIngredientNameList == null ? true : includingIngredientNameList.stream()
                .allMatch(requiredIngredientName -> recipe.getRecipeIngredients().stream()
                        .anyMatch(recipeIngredient -> recipeIngredientHasName(recipeIngredient, requiredIngredientName)));
    }

    private boolean doesNotContainIngredients(Recipe recipe, List<String> excludingIngredientNameList) {
        return excludingIngredientNameList == null ? true : excludingIngredientNameList.stream()
                .noneMatch(requiredIngredientName -> recipe.getRecipeIngredients().stream()
                        .anyMatch(recipeIngredient -> recipeIngredientHasName(recipeIngredient, requiredIngredientName)));
    }

    private boolean recipeIngredientHasName(RecipeIngredient recipeIngredient, String name) {
        return recipeIngredient.getRecipeIngredientId().getIngredient().getName().equalsIgnoreCase(name);
    }

    @Transactional
    public Recipe saveRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeDtoMapper.convertDtoToEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe;
    }

    public Recipe findById(long id) {
        return recipeRepository.findById(id).get();
    }

    public Recipe findByName(String name) {
        return recipeRepository.findByName(name);
    }
}
