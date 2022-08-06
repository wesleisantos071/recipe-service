package com.dummycook.recipeservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;
    
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