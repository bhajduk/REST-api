package com.example.demo.manager;

import com.example.demo.dao.MovieRepo;
import com.example.demo.dao.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieManager {
    private MovieRepo movieRepo;

    @Autowired
    public MovieManager(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Optional<Movie> findById(int id) {
        return movieRepo.findById(id);
    }

    public Iterable<Movie> findAll() {
        return movieRepo.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    public void deleteById(int id) {
        movieRepo.deleteById(id);
    }

    public Iterable<Movie> findMovieName() {
        return movieRepo.findMovieName();
    }

    public Iterable<Movie> findMovieNameAsc() {
        return movieRepo.findMovieNameAsc();
    }

    public Iterable<Movie> findMovieYearDesc() {
        return movieRepo.findMovieYearDesc();
    }

}
