package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.ImovelRequestDTO;
import com.example.DTO.ImovelResponseDTO;
import com.example.Model.Imovel;
import com.example.Service.ImovelService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController 
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService service;

    public ImovelController(ImovelService service){
        this.service = service;
    }

    @GetMapping 
    public List<Imovel> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Imovel buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
   
   @PostMapping 
   public ResponseEntity<ImovelResponseDTO> criar(@Valid @RequestBody ImovelRequestDTO dto){
    Imovel salvo = service.criar(dto);

    ImovelResponseDTO responseDTO = new ImovelResponseDTO();
    responseDTO.setId(salvo.getId());
    responseDTO.setEndereco(salvo.getEndereco());
    responseDTO.setDescricao(salvo.getDescricao());
    responseDTO.setValorAluguel(salvo.getValorAluguel());
    
    var uri = URI.create("/imoveis/" + salvo.getId());
    return ResponseEntity.created(uri).body(responseDTO);
   }

   @PutMapping("/{id}")
   public Imovel atualizar(@PathVariable Long id, @RequestBody Imovel novo){
    return service.atualizar(id, novo);
   }

   @DeleteMapping ("/{id}")
   public ResponseEntity<Void> deletar(@PathVariable Long id){
    service.deletar(id);
    return ResponseEntity.noContent().build();
   }
}