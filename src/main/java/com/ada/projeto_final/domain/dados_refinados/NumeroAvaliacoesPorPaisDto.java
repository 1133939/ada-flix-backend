package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NumeroAvaliacoesPorPaisDto {

    private Long id;
    private Integer quantidadeAvaliacoes;
    private String pais;
    private Filme filme;

}
