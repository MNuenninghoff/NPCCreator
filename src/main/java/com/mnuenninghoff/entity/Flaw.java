package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Flaw.
 */
@Entity(name = "Flaw")
@Table(name = "flaw")
public class Flaw {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "flaw")
    private String flaw;
    @OneToMany(mappedBy = "flaw", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Flaw.
     */
    public Flaw() {

    }

    /**
     * Instantiates a new Flaw.
     *
     * @param flaw the flaw
     */
    public Flaw(String flaw) {
        this.flaw = flaw;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets npcs.
     *
     * @return the npcs
     */
    public List<NPC> getNpcs() {
        return npcs;
    }

    /**
     * Sets npcs.
     *
     * @param npcs the npcs
     */
    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    /**
     * returns a string represenatation of the flaw
     * @return a string represenatation of the flaw
     */
    public String toString() {
        String flaw = "id: " + id + " flaw: " + this.flaw;
        return flaw;
    }

    /**
     * Gets flaw.
     *
     * @return the flaw
     */
    public String getFlaw() {
        return flaw;
    }

    /**
     * Sets flaw.
     *
     * @param flaw the flaw
     */
    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flaw flaw1 = (Flaw) o;
        return id == flaw1.id && Objects.equals(flaw, flaw1.flaw) && Objects.equals(npcs, flaw1.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flaw, npcs);
    }
}
