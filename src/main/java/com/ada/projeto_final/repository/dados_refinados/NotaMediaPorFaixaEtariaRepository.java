package com.ada.projeto_final.repository.dados_refinados;

import com.ada.projeto_final.domain.carga_bruta.UsuarioCarga;
import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaMediaPorFaixaEtariaRepository extends JpaRepository<NotaMediaPorFaixaEtaria, String> {
}
