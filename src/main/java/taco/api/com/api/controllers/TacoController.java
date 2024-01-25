package taco.api.com.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import taco.api.com.api.repositories.TacoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;

import taco.api.com.api.models.Taco;

@RestController
@RequestMapping(params = "/api/taco", produces = "application/json" )
public class TacoController {
    
    private TacoRepository tacoRepo;

    @GetMapping
    public Optional<Taco> getTacoById(Long id) {
        return tacoRepo.findById(id);
    }
    
}
