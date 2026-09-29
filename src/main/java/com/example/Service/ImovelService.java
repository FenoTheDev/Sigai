package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.DTO.ImovelRequestDTO;
import com.example.Exception.ImovelNaoEncontradoException;
import com.example.Model.Imovel;
import com.example.Repository.ImovelRepository;


@Service 
public class ImovelService {
     private final ImovelRepository repository;

    public ImovelService(ImovelRepository repository){
        this.repository = repository;
    }
     @GetMapping
    public List<Imovel> listar() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Imovel buscarPorId(@PathVariable Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ImovelNaoEncontradoException(id));

    }

    @PostMapping 
    public Imovel criar(@RequestBody ImovelRequestDTO dto){
        Imovel imovel = new Imovel();

        imovel.setDescricao(dto.getDescricao());
        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());
        
        return repository.save(imovel);
    }

    @PutMapping("/{id}")
    public Imovel atualizar(@PathVariable  Long id, @RequestBody Imovel novo){
        return repository.findById(id).map(existente -> {
            novo.setId(id);
            return repository.save(novo);
        }).orElseThrow(() -> new ImovelNaoEncontradoException(id)) ;
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
