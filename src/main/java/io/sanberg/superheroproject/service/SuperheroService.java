package io.sanberg.superheroproject.service;

import io.sanberg.superheroproject.model.Superhero;
import io.sanberg.superheroproject.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SuperheroService {
    @Autowired
    private SuperheroRepository superheroRepository;

    public Superhero saveSuperhero(Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    public Superhero updateSuperheroById(long id, Superhero superhero) {
        if (superheroRepository.findById(id).isPresent()) {
            superhero.setId(id);
            return superheroRepository.save(superhero);
        } else {
            throw new NoSuchElementException();
        }
    }

    public Superhero updateSuperhero(Superhero superhero) {
        Optional<Superhero> tempOptional = superheroRepository.findByAlias(superhero.getAlias());
        if (tempOptional.isPresent()) {
            superhero.setId(tempOptional.get().getId());
            return superheroRepository.save(superhero);
        } else {
            throw new NoSuchElementException();
        }
    }

    public Optional<Superhero> getSuperheroById(long id) {
        return superheroRepository.findById(id);
    }

    public Optional<Superhero> getSuperheroByAlias(String alias) {
        return superheroRepository.findByAlias(alias);
    }

    public Optional<List<Superhero>> getAllSuperheroes() {
        return Optional.of(superheroRepository.findAll());
    }
}
