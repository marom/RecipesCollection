package com.marom.recipe.controllers;

import com.marom.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({""})
public class HomeController {

   private RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/recipes")
    public String recipesList(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "recipes";
    }
}
