package com.ada.projeto_final.repository;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoFilme, Long> {
}
