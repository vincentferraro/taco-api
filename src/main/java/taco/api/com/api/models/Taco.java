package taco.api.com.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;



import lombok.Data;

@Data
public class Taco {
    
    
    @Id
    private Integer id;

    private String name;

    private String ingredient;

    public Taco(){
        this.id = 0;
        this.name = "";
        this.ingredient = "";
    }
    public Taco(String name, String ingredient){
        this.name = name;
        this.ingredient = ingredient;
    }

    public String toString(){
        return "id:" + this.id +", name:"+this.name + ", ingredient_id :"+ this.ingredient;
    }
}
