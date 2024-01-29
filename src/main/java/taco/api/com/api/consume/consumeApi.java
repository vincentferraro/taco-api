package taco.api.com.api.consume;

import org.springframework.web.client.RestTemplate;

import taco.api.com.api.models.Ingredient;

public class consumeApi {
    private RestTemplate rest;

    consumeApi(){
        this.rest = new RestTemplate();
    }

    public Ingredient consumeIngredientById(String id){
        return rest.getForObject("http://localhost:8080/ingredients/{id}", Ingredient.class, id);
    }
}

