package com.example.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class ImovelRequestDTO {
    @NotBlank (message = "endereco eh obrigatorio")
    private String endereco;
    @Positive 
    private Double valorAluguel;
    @Size (max = 500)
    private String descricao;

}
