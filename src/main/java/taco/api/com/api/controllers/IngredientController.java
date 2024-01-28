package taco.api.com.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import taco.api.com.api.models.Ingredient;
import taco.api.com.api.repositories.IngredientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
@RestController
@RequestMapping(path="ingredients", produces={ "application/json","text/xml"})
@CrossOrigin(origins="http://tacocloud:8080")

public class IngredientController {
    private IngredientRepository ingredientRepo;

    IngredientController(IngredientRepository indregientRepo){
        this.ingredientRepo = indregientRepo;
    }

    @GetMapping
    public String getWelcomeReponse() {
        return "Hello ingredient routes";
    }

    @GetMapping("/all")
    public Iterable<Ingredient> getIngredientAll() {
        return ingredientRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getMethodName(@PathVariable String id) {
        Optional<Ingredient> optIngr = ingredientRepo.findById(id);

        if(optIngr.isPresent()){
            return new ResponseEntity<>(optIngr.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    
}
