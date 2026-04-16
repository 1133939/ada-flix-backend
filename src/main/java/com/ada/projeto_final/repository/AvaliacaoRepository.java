package com.ada.projeto_final.repository;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtariaDto;
import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPaisDto;
import com.ada.projeto_final.domain.dados_refinados.TopFilmesPorGeneroDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFilme, Long> {

    @Query("""
        SELECT new com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtariaDto(
            CASE
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) < 18                              THEN 'ATE_17'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 18 AND 24                 THEN 'ENTRE_18_24'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 25 AND 34                 THEN 'ENTRE_25_34'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 35 AND 49                 THEN 'ENTRE_35_49'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) >= 50                             THEN 'ACIMA_50'
                ELSE 'NAO_INFORMADO'
            END as faixaEtaria,
            AVG(a.nota) as mediaNota,
            f.titulo as titulo,
            f.id as id
        )
        FROM AvaliacaoFilme a
        JOIN a.filme f
        JOIN a.usuario u
        GROUP BY
            CASE
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) < 18                              THEN 'ATE_17'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 18 AND 24                 THEN 'ENTRE_18_24'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 25 AND 34                 THEN 'ENTRE_25_34'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) BETWEEN 35 AND 49                 THEN 'ENTRE_35_49'
                WHEN (YEAR(CURRENT_DATE) - u.anoNascimento) >= 50                             THEN 'ACIMA_50'
                ELSE 'NAO_INFORMADO'
            END, f.titulo, f.id
        ORDER BY 1
    """)
    List<NotaMediaPorFaixaEtariaDto> findNotaMediaPorFaixaEtaria();


    @Query("""
        SELECT new com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPaisDto(
            COUNT(a),
            u.pais,
            f.id,
            f.titulo
        )
        FROM AvaliacaoFilme a
        JOIN a.filme f
        JOIN a.usuario u
        GROUP BY u.pais, f.id, f.titulo
        ORDER BY u.pais, COUNT(a) DESC
    """)
    List<NumeroAvaliacoesPorPaisDto> findNumeroAvaliacoesFilmePorPais();

    @Query(value = """
        SELECT f.id  AS  id,
               f.titulo        AS titulo,
               f.genero        AS genero,
               AVG(a.nota)     AS mediaNotas,
               COUNT(a.id)     AS totalAvaliacoes,
               RANK() OVER (
                   PARTITION BY f.genero
                   ORDER BY AVG(a.nota) DESC
               )               AS ranking
        FROM AVALIACAO_FILME a
        INNER JOIN filme f ON f.id = a.id_filme
        GROUP BY f.id, f.titulo, f.genero
        QUALIFY RANK() OVER (
            PARTITION BY f.genero
            ORDER BY AVG(a.nota) DESC
        ) <= 10
        ORDER BY f.genero, mediaNotas DESC
    """, nativeQuery = true)
    List<TopFilmesPorGeneroDto> findTop10FilmesPorGenero();
}
