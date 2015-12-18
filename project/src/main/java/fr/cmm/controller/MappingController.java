package fr.cmm.controller;

import fr.cmm.controller.form.SearchForm;
import fr.cmm.domain.Recipe;
import fr.cmm.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by pomme on 18/12/2015.
 */
@Controller
@RequestMapping("/api")
public class MappingController {

    @Inject
    private RecipeService recipeService;


    @RequestMapping("/recipe/{id}")
    @ResponseBody
    public Recipe recette(@PathVariable("id") String id) throws ResourceNotFoundException {
        Recipe recipe = recipeService.findById(id);

        if (recipe == null) throw new ResourceNotFoundException();

        return recipe;
    }
}

