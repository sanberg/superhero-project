package io.sanberg.superheroproject.controller;

import io.sanberg.superheroproject.model.Superhero;
import io.sanberg.superheroproject.service.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/superheroes/api")
public class SuperheroController {
    @Autowired
    private SuperheroService superheroService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable long id) {
        Optional<Superhero> superheroOptional = superheroService.getSuperheroById(id);
        return superheroOptional
                .map(superhero -> new ResponseEntity<>(superhero, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getByAlias")
    public ResponseEntity<Superhero> getSuperheroByAlias(@RequestParam String alias) {
        Optional<Superhero> superheroOptional = superheroService.getSuperheroByAlias(alias);
        return superheroOptional
                .map(superhero -> new ResponseEntity<>(superhero, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Superhero>> getAllSuperheroes() {
        Optional<List<Superhero>> superheroListOptional = superheroService.getAllSuperheroes();
        return superheroListOptional
                .map(superheroList -> new ResponseEntity<>(superheroList, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Superhero> addSuperhero(@RequestBody Superhero superhero) {
        return new ResponseEntity<>(superheroService.saveSuperhero(superhero), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Superhero> updateSuperhero(@RequestBody Superhero superhero) {
        return new ResponseEntity<>(superheroService.updateSuperhero(superhero), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Superhero> updateSuperheroById(@PathVariable long id, @RequestBody Superhero superhero) {
        return new ResponseEntity<>(superheroService.updateSuperheroById(id, superhero), HttpStatus.OK);
    }
}
