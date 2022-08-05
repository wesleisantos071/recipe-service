package com.dummycook.recipeservice.entities;


import javax.persistence.*;

@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient {
    @EmbeddedId
    private RecipeIngredientId recipeIngredientId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "unity_of_measure_fk", nullable = false)
    private UnityOfMeasure unityOfMeasure;

    public UnityOfMeasure getUnityOfMeasure() {
        return unityOfMeasure;
    }

    public void setUnityOfMeasure(UnityOfMeasure unityOfMeasure) {
        this.unityOfMeasure = unityOfMeasure;
    }

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