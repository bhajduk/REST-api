package com.example.demo.dao;

import com.example.demo.dao.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

    @Query("select title from movie")
    Iterable<Movie> findMovieName();

    @Query("select title from movie order by title asc")
    Iterable<Movie> findMovieNameAsc();

    @Query("select year, title from movie order by year desc")
    Iterable<Movie> findMovieYearDesc();
}
