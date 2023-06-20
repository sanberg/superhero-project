package io.sanberg.superheroproject.repository;

import io.sanberg.superheroproject.model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    Optional<Superhero> findByName(String name);

    Optional<Superhero> findByAlias(String alias);
}

