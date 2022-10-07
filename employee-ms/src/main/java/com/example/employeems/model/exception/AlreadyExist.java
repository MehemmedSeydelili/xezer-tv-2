package com.example.employeems.model.exception;

public class AlreadyExist extends RuntimeException{

    private final String code;

    public AlreadyExist(String code, String message) {
        super(message);
        this.code = code;
    }
}
