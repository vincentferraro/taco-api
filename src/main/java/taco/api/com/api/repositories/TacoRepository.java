package taco.api.com.api.repositories;

import org.springframework.data.repository.CrudRepository;
import taco.api.com.api.models.Taco;


public interface TacoRepository extends CrudRepository<Taco,Long> {
    
}
