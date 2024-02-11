package com.mnuenninghoff.entity;

/**
 * The type Flaw.
 */
public class Flaw {
    private int id;
    private String flaw;

    /**
     * Instantiates a new Flaw.
     */
    public Flaw() {

    }

    /**
     * returns a string represenatation of the flaw
     * @return a string represenatation of the flaw
     */
    public String toString() {
        String flaw = "id: " + id + " flaw: " + this.flaw;
        return flaw;
    }

    /**
     * Gets flaw.
     *
     * @return the flaw
     */
    public String getFlaw() {
        return flaw;
    }

    /**
     * Sets flaw.
     *
     * @param flaw the flaw
     */
    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }
}
