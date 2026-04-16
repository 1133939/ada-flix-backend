package com.ada.projeto_final.domain;

import com.ada.projeto_final.domain.carga_bruta.UsuarioCarga;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String pais;
    private Integer anoNascimento;

    @Transient
    private String id_carga;

    public Usuario(UsuarioCarga usuario) {
        this.id_carga = usuario.getUser_id();
        this.nome = usuario.getName();
        this.anoNascimento = Integer.valueOf(usuario.getBirth_year());
        this.pais = usuario.getCountry();
    }
}
