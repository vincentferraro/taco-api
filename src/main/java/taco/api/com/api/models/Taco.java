package taco.api.com.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Taco {
    
    @Id
    private Long id;

    private String name;

    private List<Ingredient> ingredients;

}
