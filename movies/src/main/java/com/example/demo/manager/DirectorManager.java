package com.example.demo.manager;

import com.example.demo.dao.DirectorRepo;
import com.example.demo.dao.entity.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorManager {
    private DirectorRepo directorRepo;

    @Autowired
    public DirectorManager(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    public Optional<Director> findById(Integer id){
        return directorRepo.findById(id);
    }

    public Iterable<Director> findAllDirectors(){          //elementy po których da się iterować, jakiegoś typu kolekcje
        return directorRepo.findAllDirectors();
    }

    public Director save(Director director){ return directorRepo.save(director); }

    public void deleteById(int id) {
        directorRepo.deleteById(id);
    }

}
