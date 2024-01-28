package taco.api.com.api.models;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Ingredient {
    
    @Id
    private  String id;

    private  String name;

    private  Type type;

    public Ingredient(String id, String name, Type type){
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
