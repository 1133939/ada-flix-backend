package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopFilmesPorGenero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
    private BigDecimal mediaNotas;
    private Long totalAvaliacoes;
    private Long ranking;


    public TopFilmesPorGenero(TopFilmesPorGeneroDto filme) {
        titulo = filme.getTitulo();
        genero = GeneroEnum.valueOf(filme.getGenero());
        mediaNotas = filme.getMediaNotas();
        totalAvaliacoes = filme.getTotalAvaliacoes();
        ranking = filme.getRanking();
    }
}
