package com.example.demo.ErrorHandling;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super("Cannot process request");
    }
}
