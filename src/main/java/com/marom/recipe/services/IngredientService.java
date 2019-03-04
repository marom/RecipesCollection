package com.marom.recipe.services;

import com.marom.recipe.commands.IngredientCommand;


public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}