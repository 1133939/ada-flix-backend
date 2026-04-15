package com.ada.projeto_final.domain;

import com.ada.projeto_final.domain.carga_bruta.FilmeCarga;
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
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String diretor;
    private Integer anoLancamento;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Transient
    private String id_carga;

    public Filme(FilmeCarga filme) {
        this.id_carga = filme.getMovie_id();
        this.titulo = filme.getTitle();
        this.diretor = filme.getDirector();
        this.anoLancamento = Integer.valueOf(filme.getRelease_year());
        this.genero = GeneroEnum.getFromName(filme.getGenre());
    }

    public static Filme generateEntity(FilmeDTO filmeDTO){
        return new Filme(null, filmeDTO.getTitulo(), filmeDTO.getDiretor(), filmeDTO.getAnoLancamento(), GeneroEnum.valueOf(filmeDTO.getGenero()), null);
    }
}
