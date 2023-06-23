package io.sanberg.superheroproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "powers")
public class Power {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    String powerName;


    @JsonIgnore
    @ManyToMany(mappedBy = "powers", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Collection<Superhero> superheroes;

    public Power() {

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

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public Power(Long id, String powerName, Collection<Superhero> superheroes) {
        this.id = id;
        this.powerName = powerName;
        this.superheroes = superheroes;
    }

    public Power(String powerName) {
        this.powerName = powerName;
        this.superheroes = superheroes;
    }
}
