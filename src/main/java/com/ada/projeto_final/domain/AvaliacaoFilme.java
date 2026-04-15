package com.ada.projeto_final.domain;

import com.ada.projeto_final.domain.carga_bruta.AvaliacaoFilmeCarga;
import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoFilme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota;

    @ManyToOne
    @JoinColumn(name="idFilme")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public AvaliacaoFilme(AvaliacaoFilmeCarga avaliacao, List<Filme> filmes, List<Usuario> usuarios) {
        this.nota = Double.valueOf(avaliacao.getRating());
        var filme = filmes.stream().filter(f -> f.getId_carga().equals(avaliacao.getMovie().getMovie_id())).findFirst().get();
        var usuario = usuarios.stream().filter(u -> u.getId_carga().equals(avaliacao.getUser().getUser_id())).findFirst().get();
        this.filme = filme;
        this.usuario = usuario;
    }

    public static AvaliacaoFilme generateEntity(AvaliarFilmeDTO dto, Filme filme){
        AvaliacaoFilme avaliacao = new AvaliacaoFilme();
        avaliacao.setNota(dto.getNota());
        avaliacao.setFilme(filme);
        return avaliacao;
    }

}
