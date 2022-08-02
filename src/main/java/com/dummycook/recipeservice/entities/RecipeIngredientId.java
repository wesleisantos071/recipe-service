package com.dummycook.recipeservice.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RecipeIngredientId implements Serializable {
    @Column(nullable = false)
    private Long serialId;

    @ManyToOne
    @JoinColumn(name = "ingredient_fk")
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe_fk")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "unity_of_measure_fk")
    private UnityOfMeasure unityOfMeasure;

    public UnityOfMeasure getUnityOfMeasure() {
        return unityOfMeasure;
    }

    public void setUnityOfMeasure(UnityOfMeasure unityOfMeasure) {
        this.unityOfMeasure = unityOfMeasure;
    }

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