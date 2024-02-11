package com.mnuenninghoff.entity;

public class Ability {
    private int id;
    private String ability;

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String toString() {
        String ability = "id: " + id + "ability: " + this.ability;
        return ability;
    }
}
