package com.marom.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({""})
public class HomeController {


    @GetMapping
    public String home() {
        System.out.println("change XXXXX");
        return "index";
    }
}
