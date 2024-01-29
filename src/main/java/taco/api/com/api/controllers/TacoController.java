package taco.api.com.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import taco.api.com.api.repositories.TacoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import taco.api.com.api.models.Taco;


import java.lang.Iterable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Slf4j
// @RestController
@RequestMapping(path = "/api/taco", produces = {"application/json","text/xml"} )
@CrossOrigin(origins="http://tacocloud:8080")
public class TacoController {
    
    private TacoRepository tacoRepo;

    TacoController(TacoRepository tacoRepo){
        this.tacoRepo = tacoRepo;
    }

    @GetMapping()
    public Iterable<Taco> getStringResponse() {
        return tacoRepo.findAll();
    }

    @GetMapping("/text")
    public String getMethod() {
        return "Hello";
    }
    
    
    @GetMapping("/{id}")
    public Optional<Taco> getTacoById(Integer id) {
        return tacoRepo.findById(id);
    }
    @GetMapping(params="recent")
  public Iterable<Taco> recentTacos() {
    PageRequest page = PageRequest.of(
            0, 12, Sort.by("createdAt").descending());
    return tacoRepo.findAll(page).getContent();
  }
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Taco> postTaco(@RequestBody Taco taco) {
        Taco tac = new Taco();
        tac.setId(taco.getId());
        tac.setName(taco.getName());
        tac.setIngredient(taco.getIngredient());
        String tacoString = tac.toString();
        log.info("tacoID : "+tacoString);
        tacoRepo.save(tac);
        Optional<Taco> tacoResponse = tacoRepo.findById(tac.getId());
        if(tacoResponse.isPresent()){
            return tacoResponse;
        }else{
            return null;
        }
        // return tacoRepo.findById(tac.getId());
    }

    @PutMapping(path="/{id}", consumes="application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Taco putTaco(@PathVariable Integer id, @RequestBody Taco taco) {
        taco.setId(id);
        return tacoRepo.save(taco);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTacos(@PathVariable Integer id){
        try{
            tacoRepo.deleteById(id);
        }catch(EmptyResultDataAccessException x){}
    }
    
}
