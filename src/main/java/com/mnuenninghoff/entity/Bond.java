package com.mnuenninghoff.entity;

/**
 * The type Bond.
 */
public class Bond {
    private int id;
    private String bond;

    /**
     * Instantiates a new Bond.
     */
    public Bond(){

    }

    /**
     * Gets bond.
     *
     * @return the bond
     */
    public String getBond() {
        return bond;
    }

    /**
     * Sets bond.
     *
     * @param bond the bond
     */
    public void setBond(String bond) {
        this.bond = bond;
    }

    /**
     * returns a string representation of the bond
     * @return string representation of a bond
     */
    public String toString(){
        String bond = "id: " + "bond: " + this.bond;
        return bond;
    }
}
