package com.dummycook.recipeservice.entities;

import javax.persistence.*;

@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient {
    @EmbeddedId
    private RecipeIngredientId recipeIngredientId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public RecipeIngredientId getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(RecipeIngredientId recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }
}