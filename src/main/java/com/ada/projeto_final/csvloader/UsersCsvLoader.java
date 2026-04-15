package com.ada.projeto_final.csvloader;


import com.ada.projeto_final.domain.carga_bruta.UsuarioCarga;
import com.ada.projeto_final.repository.carga_bruta.UsuarioCargaRepository;
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
public class UsersCsvLoader {

    @Autowired
    private UsuarioCargaRepository usuarioCargaRepository;

    public void load(InputStream inputStream) throws IOException {

        Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreSurroundingSpaces()
                .parse(reader);

        for (CSVRecord record : records) {
            String user_id = record.get("user_id");
            String name = record.get("name");
            String birth_year = record.get("birth_year");
            String country = record.get("country");
            String gender = record.get("gender");
            String email = record.get("email");
            String signup_date = record.get("signup_date");
            String preferred_device = record.get("preferred_device");

            var usuarioCarga = new UsuarioCarga(user_id, name, birth_year, country, gender, email, signup_date, preferred_device);
            usuarioCargaRepository.save(usuarioCarga);
        }
    }
}
