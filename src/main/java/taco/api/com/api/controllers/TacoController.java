package taco.api.com.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import taco.api.com.api.repositories.TacoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;
import taco.api.com.api.models.Taco;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@RestController
@RequestMapping(path = "/api/taco", produces = "application/json" )
public class TacoController {
    
    private TacoRepository tacoRepo;

    @GetMapping()
    public String getStringResponde() {
        return "Hello";
    }
    
    @GetMapping("/{id}")
    public Optional<Taco> getTacoById(Long id) {
        return tacoRepo.findById(id);
    }
    
}
