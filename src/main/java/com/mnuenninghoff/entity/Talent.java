package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Talent.
 */
@Entity(name = "Talent")
@Table(name = "talent")
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "talent")
    private String talent;
    @OneToMany(mappedBy = "talent", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Talent.
     */
    public Talent() {

    }

    /**
     * Instantiates a new Talent.
     *
     * @param talent the talent
     */
    public Talent(String talent) {
        this.talent = talent;
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
     * returns a string represenation of the talent
     * @return a string represenation of the talent
     */
    public String toString() {
        String talent = "id: " + id + " talent: " + this.talent;
        return talent;
    }

    /**
     * Gets talent.
     *
     * @return the talent
     */
    public String getTalent() {
        return talent;
    }

    /**
     * Sets talent.
     *
     * @param talent the talent
     */
    public void setTalent(String talent) {
        this.talent = talent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talent talent1 = (Talent) o;
        return id == talent1.id && Objects.equals(talent, talent1.talent) && Objects.equals(npcs, talent1.npcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, talent, npcs);
    }
}
