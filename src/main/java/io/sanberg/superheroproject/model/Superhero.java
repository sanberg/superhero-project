package io.sanberg.superheroproject.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "superhero")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String alias;
    private String origin;
    @OneToMany(mappedBy = "superhero")
    private ArrayList<Power> powers;
    @OneToMany(mappedBy = "superhero")
    private ArrayList<Weapon> weapons;

    @OneToMany(mappedBy = "superhero")
    private ArrayList<Association> associations;

    public Superhero(Long id, String name, String alias, String origin, ArrayList<Power> powers, ArrayList<Weapon> weapons, ArrayList<Association> associations) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.origin = origin;
        this.powers = powers;
        this.weapons = weapons;
        this.associations = associations;
    }

    public Superhero() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<Power> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<Power> powers) {
        this.powers = powers;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(ArrayList<Association> associations) {
        this.associations = associations;
    }
}
