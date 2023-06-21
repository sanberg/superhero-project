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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;

    public Weapon() {

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

    public Superhero getSuperhero() {
        return superhero;
    }

    public void setSuperhero(Superhero superhero) {
        this.superhero = superhero;
    }

    public Weapon(Long id, String weaponName, Superhero superhero) {
        this.id = id;
        this.weaponName = weaponName;
        this.superhero = superhero;
    }

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }
}
