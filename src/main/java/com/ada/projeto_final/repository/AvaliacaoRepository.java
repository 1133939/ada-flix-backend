package com.ada.projeto_final.repository;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtariaDto;
import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPaisDto;
import com.ada.projeto_final.domain.dados_refinados.TopFilmesPorGeneroDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFilme, Long> {


//    NotaMediaPorFaixaEtariaDto findNotaMediaPorFaixaEtaria();
//
//    TopFilmesPorGeneroDto findTopFilmesPorGenero();
//
//    NumeroAvaliacoesPorPaisDto findNumeroAvaliacoesPorPais();
}
