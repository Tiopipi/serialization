package model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private String director;

    public Movie(String name, String director)  {
        this.name = name;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    @Override
    public String toString() {
        return "Name: " + this.name + ", Director:   " + this.director;
    }
}
