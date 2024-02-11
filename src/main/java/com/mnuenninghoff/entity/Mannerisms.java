package com.mnuenninghoff.entity;

/**
 * The type Mannerisms.
 */
public class Mannerisms {
    private int id;
    private String mannerisms;

    /**
     * Instantiates a new Mannerisms.
     */
    public Mannerisms() {

    }

    /**
     * returns a string representation of the mannerisms
     * @return a string representation of the mannerisms
     */
    public String toString() {
        String mannerisms = "id: " + id + " mannerisms: " + this.mannerisms;
        return mannerisms;
    }

    /**
     * Gets mannerisms.
     *
     * @return the mannerisms
     */
    public String getMannerisms() {
        return mannerisms;
    }

    /**
     * Sets mannerisms.
     *
     * @param mannerisms the mannerisms
     */
    public void setMannerisms(String mannerisms) {
        this.mannerisms = mannerisms;
    }
}
