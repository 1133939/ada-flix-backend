package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaMediaPorFaixaEtariaRepository extends JpaRepository<NotaMediaPorFaixaEtaria, Long> {
    @Query("SELECT t FROM NotaMediaPorFaixaEtaria t WHERE t.titulo = :titulo")
    List<NotaMediaPorFaixaEtaria> findByFaixaEtaria(@Param("titulo") String titulo);
}
