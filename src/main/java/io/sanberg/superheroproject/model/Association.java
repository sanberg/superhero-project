package io.sanberg.superheroproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "associations")
public class Association {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @JsonIgnore
    @ManyToMany(mappedBy = "associations", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
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
