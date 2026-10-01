package com.example.Exception;


public class FotoNaoEncontrada extends RuntimeException{
    public FotoNaoEncontrada(Long id){
        super("Foto nao encontrada");
    }
}
