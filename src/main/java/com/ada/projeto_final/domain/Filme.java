package com.ada.projeto_final.domain;

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

    @OneToMany(mappedBy = "filme")
    private List<AvaliacaoFilme> avaliacoes;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    public static Filme generateEntity(FilmeDTO filmeDTO){
        return new Filme(null, filmeDTO.getTitulo(), filmeDTO.getDiretor(), filmeDTO.getAnoLancamento(), null, GeneroEnum.valueOf(filmeDTO.getGenero()));
    }
}
