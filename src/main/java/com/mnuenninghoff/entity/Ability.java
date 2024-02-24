package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Ability.
 */
@Entity(name = "Ability")
@Table(name = "ability")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "ability")
    private String ability;
    @OneToMany(mappedBy = "ability", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Ability.
     */
    public Ability() {
    }

    /**
     * Instantiates a new Ability.
     *
     * @param ability the ability
     */
    public Ability(String ability) {
        this.ability = ability;
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
     * Gets ability.
     *
     * @return the ability
     */
    public String getAbility() {
        return ability;
    }

    /**
     * Sets ability.
     *
     * @param ability the ability
     */
    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String toString() {
        String ability = "id: " + id + "ability: " + this.ability;
        return ability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ability ability1 = (Ability) o;
        return id == ability1.id && Objects.equals(ability, ability1.ability) && Objects.equals(npcs, ability1.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ability, npcs);
    }
}
