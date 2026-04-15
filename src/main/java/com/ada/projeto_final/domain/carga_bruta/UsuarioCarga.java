package com.ada.projeto_final.domain.carga_bruta;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioCarga {
    @Id
    private String user_id;
    private String name;
    private String birth_year;
    private String country;
    private String gender;
    private String email;
    private String signup_date;
    private String preferred_device;

    public UsuarioCarga(String user_id){
        this.user_id = user_id;
    }
}
