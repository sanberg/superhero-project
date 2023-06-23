package io.sanberg.superheroproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "superheroes")
public class Superhero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @Column(nullable = false, unique = true, updatable = false)
    private String alias;
    private String origin;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "superhero_powers_mapping",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "power_id")
    )
    private List<Power> powers;
    //@OneToMany(mappedBy = "superhero")


    @OneToMany(mappedBy = "superhero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Weapon> weapons;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "superhero_associatons_mapping",
            joinColumns = @JoinColumn(name = "superhero_id"),
            inverseJoinColumns = @JoinColumn(name = "association_id")
    )
    private List<Association> associations;

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

    public List<String> getPowers() {
        return powers.stream()
                .map(Power::getPowerName)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Power> getPowersList() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public List<String> getWeapons() {
        return weapons.stream()
                .map(Weapon::getWeaponName)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Weapon> getWeaponsList() {
        return weapons;
    }

/*  TODO Why should it be done only with custom setter?
    in case of onetomany relation
    DTO pattern?*/
    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons.stream()
                .peek(weapon -> weapon.setSuperhero(this))
                .toList();
    }

    public List<String> getAssociations() {
        return associations.stream()
                .map(Association::getAssociationText)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Association> getAssociationsList() {
        return associations;
    }

    public void setAssociations(ArrayList<Association> associations) {
        this.associations = associations;
    }
}
