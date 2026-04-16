package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NumeroAvaliacoesPorPais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidadeAvaliacoes;
    private String pais;
    private Long idFilme;
    private String titulo;

    public NumeroAvaliacoesPorPais(NumeroAvaliacoesPorPaisDto numeroAvaliacoesPorPaisDto) {
        this.quantidadeAvaliacoes = numeroAvaliacoesPorPaisDto.getQuantidadeAvaliacoes();
        this.pais = numeroAvaliacoesPorPaisDto.getPais();
        this.idFilme = numeroAvaliacoesPorPaisDto.getIdFilme();
        this.titulo = numeroAvaliacoesPorPaisDto.getTitulo();
    }
}
