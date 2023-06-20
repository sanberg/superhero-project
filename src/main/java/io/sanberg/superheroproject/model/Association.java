package io.sanberg.superheroproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "associations")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String associationText;

    @ManyToOne
    @JoinColumn(name = "superhero_id")
    private Superhero superhero;

    public Superhero getSuperhero() {
        return superhero;
    }

    public void setSuperhero(Superhero superhero) {
        this.superhero = superhero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
