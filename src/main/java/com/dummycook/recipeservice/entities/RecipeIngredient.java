package com.dummycook.recipeservice.entities;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Table(name = "recipe_ingredient")
@Entity
public class RecipeIngredient {
    @EmbeddedId
    @JsonIgnore
    private RecipeIngredientId recipeIngredientId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "recipe_fk", insertable = false, updatable = false)
    private Recipe recipe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_fk", insertable = false, updatable = false)
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
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