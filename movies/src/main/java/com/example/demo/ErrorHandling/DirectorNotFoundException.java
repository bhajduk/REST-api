package com.example.demo.ErrorHandling;

public class DirectorNotFoundException extends RuntimeException{
    public DirectorNotFoundException(int id) {
        super("Director id not found: " + id);
    }
}
