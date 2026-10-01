package com.example.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class FotoResponseDTO {
    @Id 
    @Positive 
    private Long id;
    @Positive 
    private Long imovelId;
    private String url;
    @NotBlank (message = "Tem que ter uma legenda")
    @Size (max = 200)
    private String legenda;
    private Boolean principal;
}
