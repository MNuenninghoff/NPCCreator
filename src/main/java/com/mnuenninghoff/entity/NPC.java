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
    private Ability ability;
    @ManyToOne
    private Appearance appearance;
    @ManyToOne
    private Bond bond;
    @ManyToOne
    private Flaw flaw;
    @ManyToOne
    @JoinColumn(name = "interaction_traits")
    private InteractionTraits interactionTraits;
    @ManyToOne
    private Mannerisms mannerisms;
    @ManyToOne
    private Race race;
    @ManyToOne
    private Talent talent;
    @ManyToOne
    private User user;
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

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
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
     * Gets ability.
     *
     * @return the ability
     */
    public Ability getAbility() {
        return ability;
    }

    /**
     * Sets ability.
     *
     * @param ability the ability
     */
    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    /**
     * Gets appearance.
     *
     * @return the appearance
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Sets appearance.
     *
     * @param appearance the appearance
     */
    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    /**
     * Gets bond.
     *
     * @return the bond
     */
    public Bond getBond() {
        return bond;
    }

    /**
     * Sets bond.
     *
     * @param bond the bond
     */
    public void setBond(Bond bond) {
        this.bond = bond;
    }

    /**
     * Gets flaw.
     *
     * @return the flaw
     */
    public Flaw getFlaw() {
        return flaw;
    }

    /**
     * Sets flaw.
     *
     * @param flaw the flaw
     */
    public void setFlaw(Flaw flaw) {
        this.flaw = flaw;
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
     * Gets mannerisms.
     *
     * @return the mannerisms
     */
    public Mannerisms getMannerisms() {
        return mannerisms;
    }

    /**
     * Sets mannerisms.
     *
     * @param mannerisms the mannerisms
     */
    public void setMannerisms(Mannerisms mannerisms) {
        this.mannerisms = mannerisms;
    }

    /**
     * Gets race.
     *
     * @return the race
     */
    public Race getRace() {
        return race;
    }

    /**
     * Sets race.
     *
     * @param race the race
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Gets talent.
     *
     * @return the talent
     */
    public Talent getTalent() {
        return talent;
    }

    /**
     * Sets talent.
     *
     * @param talent the talent
     */
    public void setTalent(Talent talent) {
        this.talent = talent;
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

    /**
     * provides a string representation of the NPC. Overrides toString method on object
     * @return string representing npc
     */
    public String toString() {
        String npc = "npc: " + description + ", name: " + name + ", ability: " + ability + ", appearance: " + appearance
                + ", bond: " + bond + ", flaw: " + flaw + ", interaction traits: " + interactionTraits + "mannerisms: "
                + mannerisms + "race: " + race + "talent: " + talent;

        return npc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return id == npc.id && Objects.equals(ability, npc.ability) && Objects.equals(appearance, npc.appearance) && Objects.equals(bond, npc.bond) && Objects.equals(flaw, npc.flaw) && Objects.equals(interactionTraits, npc.interactionTraits) && Objects.equals(mannerisms, npc.mannerisms) && Objects.equals(race, npc.race) && Objects.equals(talent, npc.talent) && Objects.equals(user, npc.user) && Objects.equals(description, npc.description) && Objects.equals(name, npc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ability, appearance, bond, flaw, interactionTraits, mannerisms, race, talent, user, description, name, id);
    }
}
