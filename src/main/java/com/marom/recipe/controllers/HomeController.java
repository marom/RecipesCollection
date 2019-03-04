package com.marom.recipe.controllers;

import com.marom.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   private RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/recipes"})
    public String recipesList(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }
}
