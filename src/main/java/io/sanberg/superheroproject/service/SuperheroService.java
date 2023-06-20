package io.sanberg.superheroproject.service;

import io.sanberg.superheroproject.model.Superhero;
import io.sanberg.superheroproject.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuperheroService {
    @Autowired
    private SuperheroRepository superheroRepository;

    public void saveSuperhero(Superhero superhero) {
        superheroRepository.save(superhero);
    }


    public Optional<Superhero> getSuperheroById(long id) {
        return superheroRepository.findById(id);
    }

    public Optional<Superhero> getSuperheroByAlias(String alias) {
        return superheroRepository.findByAlias(alias);
    }

}
