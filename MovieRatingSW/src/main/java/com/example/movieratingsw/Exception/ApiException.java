package com.example.movieratingsw.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
