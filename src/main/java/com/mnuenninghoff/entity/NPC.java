package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

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

    public NPC() {

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
     * Gets occupation.
     *
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Sets occupation.
     *
     * @param occupation the occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
        String npc = "npc: " + occupation + ", name: " + name + ", ability: " + ability + ", appearance: " + appearance
                + ", bond: " + bond + ", flaw: " + flaw + ", interaction traits: " + interactionTraits + "mannerisms: "
                + mannerisms + "race: " + race + "talent: " + talent;

        return npc;
    }
}
