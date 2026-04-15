package com.ada.projeto_final.domain.dados_refinados;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
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
public class TopFilmesPorGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "top_filmes_por_genero_filme",
            joinColumns = { @JoinColumn(name = "top_filmes_id") },
            inverseJoinColumns = { @JoinColumn(name = "filmes_id") }
    )
    private List<Filme> filme;

    @Enumerated(EnumType.STRING)
    private GeneroEnum generoEnum;

    public TopFilmesPorGenero(AvaliacaoFilme avaliacao) {
    }
}
