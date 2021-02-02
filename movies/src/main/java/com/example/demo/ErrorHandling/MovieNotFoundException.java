package com.example.demo.ErrorHandling;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(int id) {
        super("Movie id not found: " + id);
    }
}
