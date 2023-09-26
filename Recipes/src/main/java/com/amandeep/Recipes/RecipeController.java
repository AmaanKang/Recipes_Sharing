package com.amandeep.Recipes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return new ResponseEntity<>(recipeService.allRecipes(), HttpStatus.OK);
    }
    @GetMapping("/{ID}")
    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable int ID){
        return new ResponseEntity<>(recipeService.singleRecipe(ID),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(recipeService.createRecipe(payload.get("title"),payload.get("ingredients"),payload.get("instructions"),payload.get("image_Name")),HttpStatus.CREATED);
    }
}
