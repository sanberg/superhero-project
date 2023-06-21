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

    @ManyToMany(mappedBy = "associations", cascade = CascadeType.PERSIST)
    private Collection<Superhero> superheroes;
    private String associationText;

    public Association() {

    }


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

    public Association(Long id, Collection<Superhero> superheroes, String associationText) {
        this.id = id;
        this.superheroes = superheroes;
        this.associationText = associationText;
    }

    public Association(String associationText) {
        this.associationText = associationText;
    }
}
