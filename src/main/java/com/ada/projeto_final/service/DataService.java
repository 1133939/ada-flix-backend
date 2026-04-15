package com.ada.projeto_final.service;

import com.ada.projeto_final.domain.AvaliacaoFilme;
import com.ada.projeto_final.domain.Filme;
import com.ada.projeto_final.domain.Usuario;
import com.ada.projeto_final.domain.dados_refinados.NotaMediaPorFaixaEtaria;
import com.ada.projeto_final.domain.dados_refinados.NumeroAvaliacoesPorPais;
import com.ada.projeto_final.domain.dados_refinados.TopFilmesPorGenero;
import com.ada.projeto_final.repository.AvaliacaoRepository;
import com.ada.projeto_final.repository.FilmeRepository;
import com.ada.projeto_final.repository.UsuarioRepository;
import com.ada.projeto_final.repository.carga_bruta.AvaliacaoCargaRepository;
import com.ada.projeto_final.repository.carga_bruta.FilmeCargaRepository;
import com.ada.projeto_final.repository.carga_bruta.UsuarioCargaRepository;
import com.ada.projeto_final.repository.dados_refinados.NotaMediaPorFaixaEtariaRepository;
import com.ada.projeto_final.repository.dados_refinados.NumeroAvaliacoesPorPaisRepository;
import com.ada.projeto_final.repository.dados_refinados.TopFilmesPorGeneroRepository;
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

    @Autowired
    private UsuarioCargaRepository usuarioCargaRepository;
    @Autowired
    private AvaliacaoCargaRepository avaliacaoCargaRepository;
    @Autowired
    private FilmeCargaRepository filmeCargaRepository;

    @Autowired
    private TopFilmesPorGeneroRepository topFilmesPorGeneroRepository;
    @Autowired
    private NumeroAvaliacoesPorPaisRepository numeroAvaliacoesPorPaisRepository;
    @Autowired
    private NotaMediaPorFaixaEtariaRepository notaMediaPorFaixaEtariaRepository;

    public void processarDataWarehouse() {
        System.out.println("Iniciando carga tratada dos arquivos");
        var filmesEntity = filmeCargaRepository.findAll().stream().map(Filme::new).toList();
        var usuariosEntity = usuarioCargaRepository.findAll().stream().map(Usuario::new).toList();
        var avaliacoesEntity = avaliacaoCargaRepository.findAll().stream().map(avaliacao -> new AvaliacaoFilme(avaliacao, filmesEntity, usuariosEntity)).toList();

        filmeRepository.saveAll(filmesEntity);
        usuarioRepository.saveAll(usuariosEntity);
        avaliacaoRepository.saveAll(avaliacoesEntity);

        System.out.println("Finalizando carga tratada dos arquivos");
    }

    public void processarDataMart() {
        System.out.println("Iniciando carga mart dos arquivos");

        numeroDeAvaliacoesPorPais();
        topFilmesPorGenero();
        notaMediaPorFaixaEtaria();

        System.out.println("Finalizando carga mart dos arquivos");
    }

    private void notaMediaPorFaixaEtaria() {
//        var notaMediaPorFaixaEtaria = avaliacaoRepository.findNotaMediaPorFaixaEtaria();
//        var notaMediaPorFaixaEtarias = avaliacoes.stream().map(avaliacao -> new NotaMediaPorFaixaEtaria(avaliacao)).toList();
//        notaMediaPorFaixaEtariaRepository.saveAll(notaMediaPorFaixaEtarias);
    }

    private void topFilmesPorGenero() {
//        var topFilmesDto = avaliacaoRepository.findTopFilmesPorGenero();
//        var topFilmesPorGeneros = avaliacoes.stream().map(avaliacao -> new TopFilmesPorGenero(avaliacao)).toList();
//        topFilmesPorGeneroRepository.saveAll(topFilmesPorGeneros);
    }

    private void numeroDeAvaliacoesPorPais() {
//        var numeroAvaliacoesPorPais = avaliacaoRepository.findNumeroAvaliacoesPorPais();
//        numeroAvaliacoesPorPaisRepository.saveAll(numeroAvaliacoesPorPais);
    }
}
