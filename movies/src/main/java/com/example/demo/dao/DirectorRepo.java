package com.example.demo.dao;

import com.example.demo.dao.entity.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends CrudRepository<Director, Integer> {

    @Query("select  directorId, name, surname,dateOfBirth, country from director")
    Iterable<Director> findAllDirectors();

}
