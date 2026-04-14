package com.ada.projeto_final.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {
    private String id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
}
