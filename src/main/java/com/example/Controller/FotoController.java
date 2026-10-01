package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.FotoRequestDTO;
import com.example.DTO.FotoResponseDTO;
import com.example.Model.Foto;
import com.example.Service.FotoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping ("/fotos")
public class FotoController {
    private final FotoService service;

    public FotoController(FotoService service){
        this.service = service;
    }


    @GetMapping ("/{id}")
    public Foto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }


    @PostMapping
    public ResponseEntity<FotoResponseDTO>criar(@Valid @RequestBody FotoRequestDTO dto){
        Foto salvo = service.criar(dto);

        FotoResponseDTO responseDTO = new FotoResponseDTO();

        responseDTO.setId(salvo.getId());
        responseDTO.setImovelId(salvo.getImovelId());
        responseDTO.setLegenda(salvo.getLegenda());
        responseDTO.setUrl(salvo.getUrl());
        responseDTO.setPrincipal(salvo.getPrincipal());

        var uri = URI.create("/fotos/" + dto.getId());
        
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id){
        service.deletarFoto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Foto atualizarFoto(@PathVariable Long id, @RequestBody Foto novaFoto){
        return service.atualizarFoto(id);
    }
}
