package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPais;
import com.ada.projeto_final.domain.dados_refinados.TopFilmesPorGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopFilmesPorGeneroRepository extends JpaRepository<TopFilmesPorGenero, String> {
}
