package com.dummycook.recipeservice.dto;

import lombok.Data;

@Data
public class RecipeIngredientDto {
    private Double amount;
    private String ingredientName;
    private String unityOfMeasure;
}
