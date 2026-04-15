package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.Filme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaMediaPorFaixaEtariaDto {
    private Long id;
    private FaixaEtariaEnum faixaEtaria;
    private Filme filme;

}
