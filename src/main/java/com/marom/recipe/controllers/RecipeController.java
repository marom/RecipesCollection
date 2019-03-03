package com.marom.recipe.controllers;

import com.marom.recipe.commands.RecipeCommand;
import com.marom.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/show/{id}")
    public String getRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/addRecipe";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {

        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(recipeCommand);

        return "redirect:/recipe/show/" + savedRecipe.getId();
    }
}