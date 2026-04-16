package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtaria;
import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumeroAvaliacoesPorPaisRepository extends JpaRepository<NumeroAvaliacoesPorPais, String> {
    @Query("SELECT t FROM NumeroAvaliacoesPorPais t WHERE t.titulo = :titulo ORDER BY t.quantidadeAvaliacoes DESC")
    List<NumeroAvaliacoesPorPais> findNumeroAvaliacoesPorPais(String titulo);
}
