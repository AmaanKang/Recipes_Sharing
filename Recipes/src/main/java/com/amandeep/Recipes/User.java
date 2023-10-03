package com.amandeep.Recipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId _Id;
    private String EmailAddress;
    private int Password;

    public User(String emailAddress, String password){
        this.EmailAddress = emailAddress;
        this.Password = password.hashCode();
    }
}
