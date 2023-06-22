package io.sanberg.superheroproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String weaponName;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "superhero_id", nullable = false)
    private Superhero superheroes;

    public Weapon() {

    }

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }


    public Superhero getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(Superhero superheroes) {
        this.superheroes = superheroes;
    }
}
