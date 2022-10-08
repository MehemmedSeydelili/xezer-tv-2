package com.example.employeems.controller;

import com.example.employeems.model.dto.ExceptionDto;
import com.example.employeems.model.exception.AlreadyExistException;
import com.example.employeems.model.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.employeems.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_CODE;
import static com.example.employeems.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;

@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handle(Exception ex) {
        log.error("Exception ", ex);
        return new ExceptionDto(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handle(NotFoundException ex) {
        log.error("NotFoundException ", ex);
        return new ExceptionDto(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto handle(AlreadyExistException ex){
        log.error("AlreadyExistException ", ex);
        return new ExceptionDto(ex.getCode(), ex.getMessage());
    }

}
