package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Bond.
 */
@Entity(name = "Bond")
@Table(name = "bond")
public class Bond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "bond")
    private String bond;
    @OneToMany(mappedBy = "bond", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<NPC> npcs = new ArrayList<>();

    /**
     * Instantiates a new Bond.
     */
    public Bond(){

    }

    /**
     * Instantiates a new Bond.
     *
     * @param bond the bond
     */
    public Bond(String bond) {
        this.bond = bond;
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
     * Gets bond.
     *
     * @return the bond
     */
    public String getBond() {
        return bond;
    }

    /**
     * Sets bond.
     *
     * @param bond the bond
     */
    public void setBond(String bond) {
        this.bond = bond;
    }

    /**
     * returns a string representation of the bond
     * @return string representation of a bond
     */
    public String toString(){
        String bond = "id: " + "bond: " + this.bond;
        return bond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bond bond1 = (Bond) o;
        return id == bond1.id && Objects.equals(bond, bond1.bond);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bond, npcs);
    }
}