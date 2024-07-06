package com.dummycook.recipeservice.services;

import com.dummycook.recipeservice.dto.RecipeDto;
import com.dummycook.recipeservice.dto.RecipeDtoMapper;
import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.fixture.RecipeDtoFixture;
import com.dummycook.recipeservice.repositories.IngredientRepository;
import com.dummycook.recipeservice.repositories.RecipeRepository;
import com.dummycook.recipeservice.repositories.TypeOfUnityRepository;
import com.dummycook.recipeservice.repositories.UnityOfMeasureRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class RecipeServiceTest {

    RecipeService recipeService;

    @Mock
    IngredientRepository ingredientRepository;
    @Mock
    UnityOfMeasureRepository unityOfMeasureRepository;
    @Mock
    TypeOfUnityRepository typeOfUnityRepository;
    @Mock
    RecipeRepository recipeRepository;

    RecipeDtoMapper recipeDtoMapper;

    Recipe spaghetti;
    Recipe salmon;
    Recipe bruschetta;
    List<Recipe> allRecipes;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(ingredientRepository.save(ArgumentMatchers.any())).thenAnswer(i -> i.getArguments()[0]);
        Mockito.when(ingredientRepository.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Mockito.when(unityOfMeasureRepository.save(ArgumentMatchers.any())).thenAnswer(i -> i.getArguments()[0]);
        Mockito.when(unityOfMeasureRepository.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Mockito.when(typeOfUnityRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());
        recipeDtoMapper = new RecipeDtoMapper(ingredientRepository, unityOfMeasureRepository, typeOfUnityRepository);

        //Vegetarian/vegan recipe
        spaghetti = createRecipe(RecipeName.SPAGHETTI);
        //Non vegetarian recipe
        salmon = createRecipe(RecipeName.SALMON);
        //Non vegan recipe
        bruschetta = createRecipe(RecipeName.BRUSCHETTA);

        allRecipes = new ArrayList<>();
        allRecipes.add(spaghetti);
        allRecipes.add(salmon);
        allRecipes.add(bruschetta);

        recipeService = new RecipeService(recipeRepository);
        Mockito.when(recipeRepository.findAll()).thenReturn(allRecipes);
    }

    private Recipe createRecipe(RecipeName name) {
        RecipeDtoFixture fixture = new RecipeDtoFixture();
        switch (name) {
            case SPAGHETTI:
                RecipeDto recipeDto = fixture.generateRecipe(RecipeName.SPAGHETTI);
                return recipeDtoMapper.convertDtoToEntity(recipeDto);
            case SALMON:
                Recipe salmonRecipe = recipeDtoMapper.convertDtoToEntity(fixture.generateRecipe(RecipeName.SALMON));
//                fixture.processIsMeatIngredients(salmonRecipe.getRecipeIngredients());
//                fixture.processIsAnimalOriginatedIngredients(salmonRecipe.getRecipeIngredients());
                return salmonRecipe;
            case BRUSCHETTA:
                Recipe bruschettaRecipe = recipeDtoMapper.convertDtoToEntity(fixture.generateRecipe(RecipeName.BRUSCHETTA));
//                fixture.processIsMeatIngredients(bruschettaRecipe.getRecipeIngredients());
//                fixture.processIsAnimalOriginatedIngredients(bruschettaRecipe.getRecipeIngredients());
                return bruschettaRecipe;
        }
        return null;
    }


    @Test
    void recipeMatchesInstructionKeyWord() {
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                "crispy",
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == salmon.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    @Test
    void recipeMatchesNumberOfServing() {
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                16,
                null,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(bruschetta.getId());
    }

    @Test
    void areRecipeIngredientsVegetarian() {
        List<Recipe> resultingRecipes = recipeService.filter(true,
                null,
                null,
                null,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == spaghetti.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    @Test
    void areRecipeIngredientsNonVegetarian() {
        List<Recipe> resultingRecipes = recipeService.filter(false,
                null,
                null,
                null,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(salmon.getId());
    }

    @Test
    void areRecipeIngredientsVegan() {
        List<Recipe> resultingRecipes = recipeService.filter(null,
                true,
                null,
                null,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(spaghetti.getId());
    }

    @Test
    void areRecipeIngredientsNonVegan() {
        List<Recipe> resultingRecipes = recipeService.filter(null,
                false,
                null,
                null,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == salmon.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    @Test
    void containsIngredients() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salt");
        includesIngredientNameList.add("Olive Oil");
        includesIngredientNameList.add("Garlic");
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                null,
                includesIngredientNameList,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == spaghetti.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    @Test
    void doesNotContainIngredients() {
        List<String> excludesIngredientNameList = new ArrayList<>();
        excludesIngredientNameList.add("Salmon");
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                null,
                null,
                excludesIngredientNameList);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == spaghetti.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

    @Test
    void recipeFullFilter() {
        List<String> includesIngredientNameList = new ArrayList<>();
        includesIngredientNameList.add("Salt");
        List<String> excludesIngredientNameList = new ArrayList<>();
        excludesIngredientNameList.add("Salmon");
        String instructionKeyword = "crispy";
        List<Recipe> resultingRecipes = recipeService.filter(true,
                false,
                16,
                instructionKeyword,
                includesIngredientNameList,
                excludesIngredientNameList);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(1);
        Assertions.assertThat(resultingRecipes.get(0).getId()).isSameAs(bruschetta.getId());
    }

    @Test
    void recipeInstructionHasKeyWord() {
        String instructionKeyword = "crispy";
        List<Recipe> resultingRecipes = recipeService.filter(null,
                null,
                null,
                instructionKeyword,
                null,
                null);
        Assertions.assertThat(resultingRecipes.size()).isSameAs(2);
        Assertions.assertThat(resultingRecipes.stream().allMatch(recipe -> recipe.getId() == salmon.getId()
                || recipe.getId() == bruschetta.getId())).isTrue();
    }

}