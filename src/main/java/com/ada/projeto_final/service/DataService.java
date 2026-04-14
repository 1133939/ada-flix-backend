package com.ada.projeto_final.service;

import com.ada.projeto_final.repository.AvaliacaoRepository;
import com.ada.projeto_final.repository.FilmeRepository;
import com.ada.projeto_final.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    public void processarDataWarehouse() {
        System.out.println("Iniciando carga tratada dos arquivos");
        // TODO: Transformar os dados brutos nas entidades reais do sistema Filme, Usuario e AvaliacaoFilme
        System.out.println("Finalizando carga tratada dos arquivos");
    }

    public void processarDataMart() {
        System.out.println("Iniciando carga mart dos arquivos");
        // TODO: Criar entidades específicas para o Data Mart, como por exemplo: FilmePopular, GeneroMelhorAvaliacaoMedia, PaisAssisteMaisFilmes, etc.
        // TODO: Preencher os dados do DataWarehouse para essas entidades específicas do Data Mart, realizando as devidas transformações e agregações necessárias para atender às necessidades de análise e consulta do Data Mart.
        System.out.println("Finalizando carga mart dos arquivos");
    }
}
