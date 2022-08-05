package com.dummycook.recipeservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class RecipeIngredientId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ingredient_fk")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe_fk")
    @JsonIgnore
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}