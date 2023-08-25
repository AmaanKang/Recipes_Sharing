package com.amandeep.Recipes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllMovies(){
        return new ResponseEntity<>(recipeService.allRecipes(), HttpStatus.OK);
    }
    @GetMapping("/{ID}")
    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable int ID){
        return new ResponseEntity<>(recipeService.singleRecipe(ID),HttpStatus.OK);
    }
}
