package com.mnuenninghoff.entity;

/**
 * The type Interaction traits.
 */
public class InteractionTraits {
    private int id;
    private String interactionTraits;

    /**
     * Instantiates a new Interaction traits.
     */
    public InteractionTraits() {

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
