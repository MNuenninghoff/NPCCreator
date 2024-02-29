package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

/**
 * Represents a non player character (NPC)
 *
 * @author Michael Nuenninghoff
 */
@Entity(name = "NPC")
@Table(name = "npc")
public class NPC {
    @ManyToOne
    @JoinColumn(name = "interaction_traits")
    private InteractionTraits interactionTraits;
    @ManyToOne
    @JoinColumn(name = "ability")
    private Ability ability;
    @ManyToOne
    @JoinColumn(name = "appearance")
    private Appearance appearance;
    @ManyToOne
    @JoinColumn(name = "bond")
    private Bond bond;
    @ManyToOne
    @JoinColumn(name = "flaw")
    private Flaw flaw;
    @ManyToOne
    @JoinColumn(name = "mannerisms")
    private Mannerisms mannerisms;
    @ManyToOne
    @JoinColumn(name = "race")
    private Race race;
    @ManyToOne
    @JoinColumn(name = "talent")
    private Talent talent;
    @ManyToOne
    @JoinColumn(name = "user")
    private  User user;
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Instantiates a new Npc.
     */
    public NPC() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Mannerisms getMannerisms() {
        return mannerisms;
    }

    public void setMannerisms(Mannerisms mannerisms) {
        this.mannerisms = mannerisms;
    }

    public Flaw getFlaw() {
        return flaw;
    }

    public void setFlaw(Flaw flaw) {
        this.flaw = flaw;
    }

    public Bond getBond() {
        return bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
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
     * Gets interaction traits.
     *
     * @return the interaction traits
     */
    public InteractionTraits getInteractionTraits() {
        return interactionTraits;
    }

    /**
     * Sets interaction traits.
     *
     * @param interactionTraits the interaction traits
     */
    public void setInteractionTraits(InteractionTraits interactionTraits) {
        this.interactionTraits = interactionTraits;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return id == npc.id && Objects.equals(interactionTraits, npc.interactionTraits) && Objects.equals(ability, npc.ability) && Objects.equals(appearance, npc.appearance) && Objects.equals(description, npc.description) && Objects.equals(name, npc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interactionTraits, ability, appearance, description, name, id);
    }
}


