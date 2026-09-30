package com.example.Service;

import java.util.List;
import org.springframework.stereotype.Service;
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

    public List<Imovel> listar() {
        return repository.findAll();
    }
    
    public Imovel buscarPorId(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ImovelNaoEncontradoException(id));
    }

    public Imovel criar(ImovelRequestDTO dto){
        Imovel imovel = new Imovel();
        imovel.setDescricao(dto.getDescricao());
        imovel.setEndereco(dto.getEndereco());
        imovel.setValorAluguel(dto.getValorAluguel());
        return repository.save(imovel);
    }

    public Imovel atualizar(Long id, Imovel novo){
        return repository.findById(id).map(existente -> {
            novo.setId(id);
            return repository.save(novo);
        }).orElseThrow(() -> new ImovelNaoEncontradoException(id));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}