package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import com.ada.projeto_final.enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TopFilmesPorGeneroDto {

    private Long id;

    private List<Filme> filme;

    private GeneroEnum generoEnum;

}
