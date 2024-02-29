package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Race.
 */
@Entity(name = "Race")
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "race")
    private String race;
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Race.
     */
    public Race() {

    }

    /**
     * Instantiates a new Race.
     *
     * @param race the race
     */
    public Race(String race) {
        this.race = race;
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
     * returns a string representation of the Race
     * @return a string representation of the Race
     */
    public String toString() {
        String race = "id: " + id + " race: " + this.race;
        return race;
    }

    /**
     * Gets race.
     *
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets race.
     *
     * @param race the race
     */
    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race1 = (Race) o;
        return id == race1.id && Objects.equals(race, race1.race) && Objects.equals(npcs, race1.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, race, npcs);
    }
}