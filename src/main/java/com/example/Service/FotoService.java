package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.DTO.FotoRequestDTO;
import com.example.Exception.FotoNaoEncontrada;
import com.example.Model.Foto;
import com.example.Repository.FotoRepository;

@Service 
public class FotoService {
    private final FotoRepository repository;

    public FotoService(FotoRepository repository){
        this.repository = repository;
    }


    public Foto criar(FotoRequestDTO fotoDto){
        Foto foto = new Foto();

        foto.setId(fotoDto.getId());
        foto.setImovelId(fotoDto.getImovelId());
        foto.setLegenda(fotoDto.getLegenda());
        foto.setUrl(fotoDto.getUrl());
        foto.setPrincipal(fotoDto.getPrincipal());

        return repository.save(foto);
    }


    public Foto buscarPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new FotoNaoEncontrada(id));
    }

    public Foto atualizarFoto(Long id){
        Foto fotoExistente = repository.findById(id)
        .orElseThrow(() -> new FotoNaoEncontrada(id));

        return repository.save(fotoExistente);
    }


    public void deletarFoto(Long id){
        repository.deleteById(id);
    }
}
