package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
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
    @ManyToOne
    private Filme filme;

    public NotaMediaPorFaixaEtaria(AvaliacaoFilme avaliacao) {
    }
}
