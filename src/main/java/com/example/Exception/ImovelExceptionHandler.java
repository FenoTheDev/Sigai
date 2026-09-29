package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class ImovelExceptionHandler {
    @ResponseStatus (HttpStatus.NOT_FOUND)
    @ExceptionHandler(ImovelNaoEncontradoException.class)
    public String handle(ImovelNaoEncontradoException ex){
        return ex.getMessage();
    }
}
