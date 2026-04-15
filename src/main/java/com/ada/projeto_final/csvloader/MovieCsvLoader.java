package com.ada.projeto_final.csvloader;


import com.ada.projeto_final.domain.carga_bruta.FilmeCarga;
import com.ada.projeto_final.repository.FilmeRepository;
import com.ada.projeto_final.repository.carga_bruta.FilmeCargaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
public class MovieCsvLoader {

    @Autowired
    private FilmeCargaRepository filmeCargaRepository;

    public void load(InputStream inputStream) throws IOException {

        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreSurroundingSpaces()
                .parse(reader);

        for (CSVRecord record : records) {
            String movieId = record.get("movie_id");
            String title = record.get("title");
            String director = record.get("director");
            String release_year = record.get("release_year");
            String genre = record.get("genre");
            String duration_minutes = record.get("duration_minutes");
            String budget_million = record.get("budget_million");
            String language = record.get("language");
            String created_at = record.get("created_at");

            FilmeCarga filmeCarga = new FilmeCarga(movieId, title, director, release_year, genre, duration_minutes, budget_million, language, created_at);
            filmeCargaRepository.save(filmeCarga);
        }
    }
}
