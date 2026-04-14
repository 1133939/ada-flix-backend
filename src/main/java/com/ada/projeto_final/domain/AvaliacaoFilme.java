package com.ada.projeto_final.domain;

import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer nota;

    @ManyToOne
    @JoinColumn(name="idFilme")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public static AvaliacaoFilme generateEntity(AvaliarFilmeDTO dto, Filme filme){
        AvaliacaoFilme avaliacao = new AvaliacaoFilme();
        avaliacao.setNota(dto.getNota());
        avaliacao.setFilme(filme);
        return avaliacao;
    }

}
