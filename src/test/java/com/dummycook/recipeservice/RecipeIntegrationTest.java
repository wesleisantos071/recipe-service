package com.dummycook.recipeservice;

import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.repositories.RecipeRepository;
import com.dummycook.recipeservice.fixture.RecipeDtoFixture;
import com.dummycook.recipeservice.services.RecipeName;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeIntegrationTest {
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDtoFixture fixture;

    Recipe spaghetti;
    Recipe salmon;
    Recipe bruschetta;

//    @BeforeEach
//    void setUp() {
//        spaghetti = fixture.generateRecipe(RecipeName.SPAGHETTI);
//    }
}
