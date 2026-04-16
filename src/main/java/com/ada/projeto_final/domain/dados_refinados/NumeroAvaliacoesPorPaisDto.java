package com.ada.projeto_final.domain.dados_refinados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class NumeroAvaliacoesPorPaisDto {

    private Long quantidadeAvaliacoes;
    private String pais;
    private Long idFilme;
    private String titulo;

}
