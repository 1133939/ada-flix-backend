package com.ada.projeto_final.csvloader;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Service
public class RatingsCsvLoader {

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
            Integer year = Integer.valueOf(record.get("release_year"));
            String genre = record.get("genre");

            // Aqui você salva no STAGING
        }
    }
}
