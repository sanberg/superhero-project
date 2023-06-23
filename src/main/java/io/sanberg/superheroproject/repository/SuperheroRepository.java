package io.sanberg.superheroproject.repository;

import io.sanberg.superheroproject.model.Association;
import io.sanberg.superheroproject.model.Power;
import io.sanberg.superheroproject.model.Superhero;
import io.sanberg.superheroproject.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
    @Transactional
    @Modifying
    @Query("""
            update Superhero s set s.powers = ?1, s.weapons = ?2, s.associations = ?3, s.origin = ?4, s.name = ?5
            where s.id = ?6""")
    void updatePowersAndWeaponsAndAssociationsAndOriginAndNameById(@Nullable Power powers, @Nullable Weapon weapons, @Nullable Association associations, @Nullable String origin, @Nullable String name, Long id);
    Optional<Superhero> findByName(String name);

    Optional<Superhero> findByAlias(String alias);
}

