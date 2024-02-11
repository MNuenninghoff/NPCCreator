package com.mnuenninghoff.entity;

/**
 * The type Race.
 */
public class Race {
    private int id;
    private String race;

    /**
     * Instantiates a new Race.
     */
    public Race() {

    }

    /**
     * returns a string representation of the Race
     * @return a string representation of the Race
     */
    public String toString() {
        String race = "id: " + id + " race: " + this.race;
        return race;
    }

    /**
     * Gets race.
     *
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets race.
     *
     * @param race the race
     */
    public void setRace(String race) {
        this.race = race;
    }
}
