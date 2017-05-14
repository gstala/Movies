package com.stala.grzegorz.lab2.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 09.04.2017.
 */
public class Movie {

    private String title, genre, year, desc;
    private float grade;
    private List<Actor> actors;
    private List<Integer> images;

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        actors = new ArrayList<>();
        images = new ArrayList<>();
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public Movie() {
        images = new ArrayList<>();
        actors = new ArrayList<>();
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public  void addImage(int image){this.getImages().add(image);}

    public void addActor(Actor actor){this.actors.add(actor);}

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
