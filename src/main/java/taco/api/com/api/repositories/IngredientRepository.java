package taco.api.com.api.repositories;

import org.springframework.data.repository.CrudRepository;
import taco.api.com.api.models.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
    
}
