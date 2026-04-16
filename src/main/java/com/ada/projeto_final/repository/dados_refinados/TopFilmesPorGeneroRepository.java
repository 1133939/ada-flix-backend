package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPais;
import com.ada.projeto_final.domain.dados_refinados.TopFilmesPorGenero;
import com.ada.projeto_final.enums.GeneroEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopFilmesPorGeneroRepository extends JpaRepository<TopFilmesPorGenero, String> {
    @Query("SELECT t FROM TopFilmesPorGenero t WHERE t.genero = :genero ORDER BY t.ranking DESC")
    List<TopFilmesPorGenero> findByGenero(@Param("genero") GeneroEnum genero);
}
