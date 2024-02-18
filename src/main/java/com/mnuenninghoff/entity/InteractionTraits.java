package com.mnuenninghoff.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Interaction traits.
 */
@Entity(name = "InteractionTraits")
@Table(name = "Interaction_Traits")
public class InteractionTraits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "trait")
    private String interactionTraits;

    /**
     * Instantiates a new Interaction traits.
     */
    public InteractionTraits() {

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
     * returns a string representation of the interaction traits
     * @return a string representation of the interaction traits
     */
    public String toString() {
        String interactionTraits = "id: " + id + " interaction traits: " + this.interactionTraits;
        return interactionTraits;
    }

    /**
     * Gets interaction traits.
     *
     * @return the interaction traits
     */
    public String getInteractionTraits() {
        return interactionTraits;
    }

    /**
     * Sets interaction traits.
     *
     * @param interactionTraits the interaction traits
     */
    public void setInteractionTraits(String interactionTraits) {
        this.interactionTraits = interactionTraits;
    }
}
