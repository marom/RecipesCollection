package com.marom.recipe.services;

import com.marom.recipe.domain.Recipe;
import com.marom.recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    public Recipe findById(Long recipeId) {

        Optional<Recipe> recipe = recipeRepository.findById(recipeId);

        if (!recipe.isPresent()) {
            throw new RuntimeException(("Recipe not found!!!"));
        }
        return recipe.get();
    }
}
