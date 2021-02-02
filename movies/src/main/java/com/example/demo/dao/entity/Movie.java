package com.example.demo.dao.entity;

import javax.persistence.*;

@Entity(name="movie")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int movieId;
    private String title;
    private int year;
    private String country;

    public Movie() {
    }

    public Movie(int movieId, String title, int year, String country) {
        this.movieId = movieId;
        this.title = title;
        this.year = year;
        this.country = country;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
