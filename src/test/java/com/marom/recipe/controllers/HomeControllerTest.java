package com.marom.recipe.controllers;

import com.marom.recipe.domain.Recipe;
import com.marom.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class HomeControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    HomeController homeController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        homeController = new HomeController(recipeService);
    }

    @Test
    public void recipesList() {

        String view = homeController.recipesList(model);
        assertThat(view, is("recipes"));

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }

    @Test
    public void argumentCapture() {

        //given
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);

        Recipe recipe2 = new Recipe();
        recipe2.setId(2L);

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String viewName = homeController.recipesList(model);

        //then
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertThat(setInController.size(), is(2));
    }

    @Test
    public void mocMvcController() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setViewResolvers(viewResolver())
                .build();

        mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipes"));
    }

    private ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("classpath:templates/");
        viewResolver.setSuffix(".html");

        return viewResolver;
    }
}
