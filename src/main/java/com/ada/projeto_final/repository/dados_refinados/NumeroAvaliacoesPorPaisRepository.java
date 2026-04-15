package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtaria;
import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumeroAvaliacoesPorPaisRepository extends JpaRepository<NumeroAvaliacoesPorPais, String> {
}
