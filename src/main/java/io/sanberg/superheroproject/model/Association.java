package io.sanberg.superheroproject.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "associations")
    private Collection<Superhero> superheroes;
    private String associationText;


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

    public String getAssociationText() {
        return associationText;
    }

    public void setAssociationText(String associationText) {
        this.associationText = associationText;
    }
}
