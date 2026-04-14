package com.ada.projeto_final.service;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.repository.AvaliacaoRepository;
import com.ada.projeto_final.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlixService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Transactional
    public void avaliarFilme(AvaliarFilmeDTO avaliarFilmeDTO) {
        var filme = filmeRepository.findById(avaliarFilmeDTO.getIdFilme()).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        var avaliacaoFilme = AvaliacaoFilme.generateEntity(avaliarFilmeDTO, filme);
        avaliacaoRepository.save(avaliacaoFilme);
    }

    @Transactional
    public void cadastrarFilme(FilmeDTO filmeDto) {
        var filme = Filme.generateEntity(filmeDto);
        filmeRepository.save(filme);
    }

    public String topFilmesMaisPopulares() {
        return "";
    }

    public String generoMelhorAvaliacaoMedia() {
        return "";
    }

    public String paisAssisteMaisFilmes() {
        return "";
    }
}
