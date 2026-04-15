package com.ada.projeto_final.domain.carga_bruta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmeCarga {

    @Id
    private String movie_id;
    private String title;
    private String director;
    private String release_year;
    private String genre;
    private String duration_minutes;
    private String budget_million;
    private String language;
    private String created_at;

    public FilmeCarga(String movie_id){
        this.movie_id = movie_id;
    }
}
