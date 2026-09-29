package com.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ImovelResponseDTO {

    private String endereco;
    private Double valorAluguel;
    private String descricao;
    private Long id;

}

