package com.dummycook.recipeservice.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RecipeDto {
    private String name;
    private String instructions;
    private Integer number_of_servings;
    private Set<RecipeIngredientDto> recipeIngredients = new HashSet<>(0);
}
