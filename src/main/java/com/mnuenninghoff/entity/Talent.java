package com.mnuenninghoff.entity;

/**
 * The type Talent.
 */
public class Talent {
    private int id;
    private String talent;

    /**
     * Instantiates a new Talent.
     */
    public Talent() {

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
}
