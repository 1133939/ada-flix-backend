package com.ada.projeto_final.repository.carga_bruta;

import com.ada.projeto_final.domain.carga_bruta.UsuarioCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCargaRepository extends JpaRepository<UsuarioCarga, String> {
}
