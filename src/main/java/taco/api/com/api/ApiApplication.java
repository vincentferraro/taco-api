package taco.api.com.api;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.JdbcMappingContext;

import taco.api.com.api.models.Ingredient;
import taco.api.com.api.models.Taco;
import taco.api.com.api.models.Ingredient.Type;
import taco.api.com.api.repositories.TacoRepository;
import taco.api.com.api.repositories.IngredientRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	@Bean
    public JdbcMappingContext jdbcMappingContext() {
        return new JdbcMappingContext();
    }

	// @Bean
	// public CommandLineRunner dataLoader(
	// 	IngredientRepository repo,
	// 	TacoRepository tacoRepo){
	// 	return args -> {
	// 	Ingredient flourTortilla = new Ingredient(
    //     "FLTO", "Flour Tortilla", Type.WRAP);
    // 	Ingredient cornTortilla = new Ingredient(
    // 	    "COTO", "Corn Tortilla", Type.WRAP);
    // 	Ingredient groundBeef = new Ingredient(
    // 	    "GRBF", "Ground Beef", Type.PROTEIN);
    // 	Ingredient carnitas = new Ingredient(
    // 	    "CARN", "Carnitas", Type.PROTEIN);
    // 	Ingredient tomatoes = new Ingredient(
    // 	    "TMTO", "Diced Tomatoes", Type.VEGGIES);
    // 	Ingredient lettuce = new Ingredient(
    // 	    "LETC", "Lettuce", Type.VEGGIES);
    // 	Ingredient cheddar = new Ingredient(
    // 	    "CHED", "Cheddar", Type.CHEESE);
    // 	Ingredient jack = new Ingredient(
    // 	    "JACK", "Monterrey Jack", Type.CHEESE);
    // 	Ingredient salsa = new Ingredient(
    // 	    "SLSA", "Salsa", Type.SAUCE);
    // 	Ingredient sourCream = new Ingredient(
    // 	    "SRCR", "Sour Cream", Type.SAUCE);
    	
    // 	Taco taco1 = new Taco(1L,"Carnivore",Arrays.asList(
	// 		flourTortilla, groundBeef, carnitas,
	// 		sourCream, salsa, cheddar));
    // 	tacoRepo.save(taco1);
    // 	Taco taco2 = new Taco(2L,"Bovine Bounty",Arrays.asList(
	// 		cornTortilla, groundBeef, cheddar,
	// 		jack, sourCream) );
    // 	tacoRepo.save(taco2);
    // 	Taco taco3 = new Taco( 3L,"Veg-Out",Arrays.asList(
	// 		flourTortilla, cornTortilla, tomatoes,
	// 		lettuce, salsa));
    // 	tacoRepo.save(taco3);
	// 	};
	// }
	
}
