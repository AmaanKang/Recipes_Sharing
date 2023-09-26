package com.amandeep.Recipes;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> allRecipes(){
        return recipeRepository.findAll();
    }
    public Optional<Recipe> singleRecipe(int ID){
        return recipeRepository.findRecipeByID(ID);
    }

    public Recipe createRecipe(String title,String ingredients,String instructions,String image_Name){
        long allIds = recipeRepository.count();
        int newId = (int) ((allIds)+1);
        Recipe newRecipe = new Recipe(newId, title,ingredients,instructions,image_Name);
        recipeRepository.insert(newRecipe);
        return newRecipe;
    }
}
