package com.amandeep.Recipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private ObjectId _Id;
    private int ID;
    private String Title;
    private String Ingredients;
    private String Instructions;
    private String Image_Name;
    private String Cleaned_Ingredients;
    @DocumentReference
    private List<Review> reviewIds;

    public Recipe(int id, String title,String ingredients,String instructions,String image_Name){
        this.ID = id;
        this.Title = title;
        this.Ingredients = ingredients;
        this.Instructions = instructions;
        this.Image_Name = image_Name;
        this.Cleaned_Ingredients = "";
    }
}
