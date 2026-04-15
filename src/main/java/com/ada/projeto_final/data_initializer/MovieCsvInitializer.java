package com.ada.projeto_final.data_initializer;


import com.ada.projeto_final.csvloader.MovieCsvLoader;
import com.ada.projeto_final.csvloader.RatingsCsvLoader;
import com.ada.projeto_final.csvloader.UsersCsvLoader;
import com.ada.projeto_final.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class MovieCsvInitializer implements CommandLineRunner {

    @Autowired
    private MovieCsvLoader movieCsvLoader;
    @Autowired
    private RatingsCsvLoader ratingsCsvLoader;
    @Autowired
    private UsersCsvLoader usersCsvLoader;
    @Autowired
    private DataService dataService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Iniciando carga bruta dos arquivos");
        loadMovies();
        loadUsers();
        loadRatings();

        System.out.println("Carga bruta dos arquivos finalizada");

        dataService.processarDataWarehouse();
        dataService.processarDataMart();
    }

    private void loadRatings() throws IOException {
        ClassPathResource resource =
                new ClassPathResource("data/ratings.csv");

        try (InputStream inputStream = resource.getInputStream()) {
            System.out.println("Iniciando carga ratings.csv");
            ratingsCsvLoader.load(inputStream);
        }

        System.out.println("Carga do arquivo ratings.csv finalizada com sucesso.");
    }

    private void loadUsers() throws IOException {
        ClassPathResource resource =
                new ClassPathResource("data/users.csv");

        try (InputStream inputStream = resource.getInputStream()) {
            System.out.println("Iniciando carga users.csv");
            usersCsvLoader.load(inputStream);
        }

        System.out.println("Carga do arquivo users.csv finalizada com sucesso.");
    }

    private void loadMovies()  throws IOException {
        ClassPathResource resource =
                new ClassPathResource("data/movies.csv");

        try (InputStream inputStream = resource.getInputStream()) {
            System.out.println("Iniciando carga movies.csv");
            movieCsvLoader.load(inputStream);
        }

        System.out.println("Carga do arquivo movies.csv finalizada com sucesso.");
    }
}

