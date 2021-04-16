package com.springframework.spring5recipeapp.services;

import com.springframework.spring5recipeapp.domain.Recipe;
import com.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp(){
        // tells mockito to give mock recipeRepository
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        // tell mockito mock to return something
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }
}