package com.ada.projeto_final.csvloader;


import com.ada.projeto_final.domain.carga_bruta.AvaliacaoFilmeCarga;
import com.ada.projeto_final.domain.carga_bruta.FilmeCarga;
import com.ada.projeto_final.domain.carga_bruta.UsuarioCarga;
import com.ada.projeto_final.repository.carga_bruta.AvaliacaoCargaRepository;
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
public class RatingsCsvLoader {

    @Autowired
    private AvaliacaoCargaRepository avaliacaoCargaRepository;

    public void load(InputStream inputStream) throws IOException {

        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreSurroundingSpaces()
                .parse(reader);

        for (CSVRecord record : records) {

            String rating_id = record.get("rating_id");
            String user_id = record.get("user_id");
            String movie_id = record.get("movie_id");
            String rating = record.get("rating");
            String rating_date = record.get("rating_date");
            String platform = record.get("platform");
            String session_duration_minutes = record.get("session_duration_minutes");
            String location = record.get("location");

            var avaliacaoCarga = new AvaliacaoFilmeCarga(rating_id, new UsuarioCarga(user_id), new FilmeCarga(movie_id), rating, rating_date, platform, session_duration_minutes, location);
            avaliacaoCargaRepository.save(avaliacaoCarga);
        }
    }
}
