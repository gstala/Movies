package com.stala.grzegorz.lab2.Models;

/**
 * Created by Grzegorz on 13.05.2017.
 */

public class Actor {

    private String fullName;
    private int image;

    public Actor(String fullName, int image) {
        this.fullName = fullName;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (image != actor.image) return false;
        return fullName != null ? fullName.equals(actor.fullName) : actor.fullName == null;

    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + image;
        return result;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
