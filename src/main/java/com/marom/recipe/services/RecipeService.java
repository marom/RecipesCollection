package com.marom.recipe.services;

import com.marom.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long recipeId);
}
