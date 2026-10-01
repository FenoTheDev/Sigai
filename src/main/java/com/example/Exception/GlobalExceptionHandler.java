package com.example.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
        @ResponseStatus (HttpStatus.BAD_REQUEST)
        @ExceptionHandler (MethodArgumentNotValidException.class)
        public ProblemDetail handleValidation(MethodArgumentNotValidException ex){
            var pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Erro de validacao");
            pd.setProperty("errors", extrairErros(ex));
            return pd;
        }


    private Map<String, String> extrairErros(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();
        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            erros.put(fieldError.getField(), fieldError.getDefaultMessage());

        }
        return erros;
    }

    @ResponseStatus (HttpStatus.NOT_FOUND)
    @ExceptionHandler (ImovelNaoEncontradoException.class)
    public ProblemDetail handleNaoEncontrado(ImovelNaoEncontradoException ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Imovel nao encontrado");
        pd.setDetail(ex.getMessage());
        return pd;
    }

    @ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetail handdleException(Exception ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("Erro interno do servidor");
        pd.setDetail("Ocorreu um erro inesperado: " + ex.getMessage());
        return pd;
    }

    @ExceptionHandler (FotoNaoEncontrada.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ProblemDetail fotoHandleNEncontrado(FotoNaoEncontrada ex){
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pd.setTitle("Foto nao encontrada");
        pd.setDetail("Aconteceu um erro: " + ex.getMessage());

        return pd;
    }
}
