package com.mnuenninghoff.entity;

/**
 * The type Appearance.
 */
public class Appearance {
    private int id;
    private String appearance;

    /**
     * Instantiates a new Appearance.
     */
    public Appearance() {

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
}
