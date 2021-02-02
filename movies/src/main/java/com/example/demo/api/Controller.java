package com.example.demo.api;

import com.example.demo.ErrorHandling.BadRequestException;
import com.example.demo.ErrorHandling.DirectorNotFoundException;
import com.example.demo.ErrorHandling.MovieNotFoundException;
import com.example.demo.dao.entity.Director;
import com.example.demo.dao.entity.Movie;
import com.example.demo.manager.DirectorManager;
import com.example.demo.manager.MovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    private MovieManager movieManager;
    private DirectorManager directorManager;

    @Autowired
    public Controller(MovieManager movieManager, DirectorManager directorManager) {
        this.movieManager = movieManager;
        this.directorManager = directorManager;
    }

    @GetMapping("/director/all")
    public Iterable<Director> getAllDirectors() {
        return directorManager.findAllDirectors();
    }

    @GetMapping("/director/id")
    public Optional<Director> getSpecificDirector(@RequestParam int index) {
        return Optional.ofNullable(directorManager.findById(index).orElseThrow(() -> new DirectorNotFoundException(index)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/director")
    public Director addDirector(@RequestBody Director director) {
        try {
            return directorManager.save(director);
        }
        catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @GetMapping("/movie/all")
    public Iterable<Movie> getAllMovies() {
        return movieManager.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie) {
        try {
            return movieManager.save(movie);
        }
        catch (Exception e) {
            throw new BadRequestException();
        }
    }

    @GetMapping("/movie/all/name")
    public Iterable<Movie> findMovieName() {
        return movieManager.findMovieName();
    }

    @GetMapping("/movie/all/name-asc")
    public Iterable<Movie> findMovieNameAsc() {
        return movieManager.findMovieNameAsc();
    }

    @GetMapping("/movie/all/year-desc")
    public Iterable<Movie> findMovieYearDesc() {
        return movieManager.findMovieYearDesc();
    }

    @DeleteMapping("/movie")
    public void removeMovie(@RequestParam int movieId) {
        try {
            movieManager.deleteById(movieId);
        }
        catch (Exception e) {
            throw new MovieNotFoundException(movieId);
        }
    }
}
