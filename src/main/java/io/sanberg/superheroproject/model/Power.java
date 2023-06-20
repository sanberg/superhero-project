package io.sanberg.superheroproject.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "powers")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String powerName;

    @ManyToMany(mappedBy = "powers")
    private Collection<Superhero> superheroes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(Collection<Superhero> superheroes) {
        this.superheroes = superheroes;
    }
}
