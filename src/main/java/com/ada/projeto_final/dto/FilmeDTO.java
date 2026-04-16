package com.ada.projeto_final.dto;

import com.ada.projeto_final.enums.GeneroEnum;
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
    private Integer anoLancamento;
    private GeneroEnum genero;
}
