package com.ada.projeto_final.domain.carga_bruta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoFilmeCarga {
    @Id
    private String rating_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UsuarioCarga user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="movie_id")
    private FilmeCarga movie;
    private String rating;
    private String rating_date;
    private String platform;
    private String session_duration_minutes;
    private String location;
}
