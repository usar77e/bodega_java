package com.bodega.backend.exception;

public class ModelNoFoundException extends RuntimeException{
    public ModelNoFoundException(String message){
        super(message);
    }
}
