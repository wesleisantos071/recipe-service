package com.dummycook.recipeservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeIngredientId implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeIngredientId that = (RecipeIngredientId) o;
        return ingredient != null && Objects.equals(ingredient, that.ingredient)
                && recipe != null && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, recipe);
    }
}