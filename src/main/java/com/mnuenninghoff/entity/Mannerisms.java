package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Mannerisms.
 */
@Entity(name = "Mannerisms")
@Table(name = "mannerisms")
public class Mannerisms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "mannerisms")
    private String mannerisms;
    @OneToMany(mappedBy = "mannerisms", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Mannerisms.
     */
    public Mannerisms() {

    }

    /**
     * Instantiates a new Mannerisms.
     *
     * @param mannerisms the mannerisms
     */
    public Mannerisms(String mannerisms) {
        this.mannerisms = mannerisms;
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
     * returns a string representation of the mannerisms
     * @return a string representation of the mannerisms
     */
    public String toString() {
        String mannerisms = "id: " + id + " mannerisms: " + this.mannerisms;
        return mannerisms;
    }

    /**
     * Gets mannerisms.
     *
     * @return the mannerisms
     */
    public String getMannerisms() {
        return mannerisms;
    }

    /**
     * Sets mannerisms.
     *
     * @param mannerisms the mannerisms
     */
    public void setMannerisms(String mannerisms) {
        this.mannerisms = mannerisms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mannerisms that = (Mannerisms) o;
        return id == that.id && Objects.equals(mannerisms, that.mannerisms) && Objects.equals(npcs, that.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mannerisms, npcs);
    }
}