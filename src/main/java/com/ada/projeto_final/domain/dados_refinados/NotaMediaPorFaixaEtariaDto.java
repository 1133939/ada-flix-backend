package com.ada.projeto_final.domain.dados_refinados;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaMediaPorFaixaEtariaDto {

    private FaixaEtariaEnum faixaEtaria;
    private String titulo;
    private Double mediaNota;
    private Long idFilme;


    public NotaMediaPorFaixaEtariaDto(String faixaEtaria, Double mediaNota, String titulo, Long idFilme){
        this.faixaEtaria = FaixaEtariaEnum.valueOf(faixaEtaria);
        this.idFilme = idFilme;
        this.mediaNota = mediaNota;
        this.titulo = titulo;
    }
}
