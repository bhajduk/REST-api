package com.example.demo.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="director")
public class Director {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int directorId;
    private String name;
    private String surname;
    private int dateOfBirth;
    private String country;
    @OneToMany(targetEntity = Movie.class,cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="directorId", referencedColumnName = "directorId")
    private List<Movie> movies = new ArrayList<>();

    public Director() {
    }

    public Director(int directorId, String name, String surname, int dateOfBirth, String country, List<Movie> movies) {
        this.directorId = directorId;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
