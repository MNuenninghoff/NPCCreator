package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Appearance.
 */
@Entity(name = "Appearance")
@Table(name = "appearance")
public class Appearance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "appearance")
    private String appearance;
    @OneToMany(mappedBy = "appearance", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Appearance.
     */
    public Appearance() {

    }

    /**
     * Instantiates a new Appearance.
     *
     * @param appearance the appearance
     */
    public Appearance(String appearance) {
        this.appearance = appearance;
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
     * Gets appearance.
     *
     * @return the appearance
     */
    public String getAppearance() {
        return appearance;
    }

    /**
     * Sets appearance.
     *
     * @param appearance the appearance
     */
    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    /**
     * returns a string representation of the appearance
     * @return
     */
    public String toString() {
        String appearance = "id: " + id + "appearance: " + this.appearance;
        return appearance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appearance that = (Appearance) o;
        return id == that.id && Objects.equals(appearance, that.appearance) && Objects.equals(npcs, that.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appearance, npcs);
    }
}