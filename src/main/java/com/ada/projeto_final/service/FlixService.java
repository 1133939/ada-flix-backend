package com.ada.projeto_final.service;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import com.ada.projeto_final.domain.dados_refinados.*;
import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.enums.GeneroEnum;
import com.ada.projeto_final.repository.AvaliacaoRepository;
import com.ada.projeto_final.repository.FilmeRepository;
import com.ada.projeto_final.repository.dados_refinados.NotaMediaPorFaixaEtariaRepository;
import com.ada.projeto_final.repository.dados_refinados.NumeroAvaliacoesPorPaisRepository;
import com.ada.projeto_final.repository.dados_refinados.TopFilmesPorGeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlixService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
    @Autowired
    private TopFilmesPorGeneroRepository topFilmesPorGeneroRepository;
    @Autowired
    private NumeroAvaliacoesPorPaisRepository numeroAvaliacoesPorPaisRepository;
    @Autowired
    private NotaMediaPorFaixaEtariaRepository notaMediaPorFaixaEtariaRepository;

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

    public List<NotaMediaPorFaixaEtaria> notaMediaPorFaixaEtarias(String titulo) {
        return notaMediaPorFaixaEtariaRepository.findByFaixaEtaria(titulo);
    }

    public List<NumeroAvaliacoesPorPais> numeroAvaliacoesPorPais(String titulo) {
        return numeroAvaliacoesPorPaisRepository.findNumeroAvaliacoesPorPais(titulo);
    }

    public List<TopFilmesPorGenero> topFilmesMaisPopulares(GeneroEnum genero) {
        return topFilmesPorGeneroRepository.findByGenero(genero);
    }
}
