package com.ada.projeto_final.domain.dados_refinados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaMediaPorFaixaEtaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private FaixaEtariaEnum faixaEtaria;
    private String titulo;
    private Double mediaNota;
    private Long idFilme;

    public NotaMediaPorFaixaEtaria(NotaMediaPorFaixaEtariaDto notaMediaPorFaixaEtariaDto) {
        this.faixaEtaria = notaMediaPorFaixaEtariaDto.getFaixaEtaria();
        this.titulo  = notaMediaPorFaixaEtariaDto.getTitulo();
        this.mediaNota = notaMediaPorFaixaEtariaDto.getMediaNota();
        this.idFilme = notaMediaPorFaixaEtariaDto.getIdFilme();
    }
}
