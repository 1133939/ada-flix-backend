package com.ada.projeto_final.resource;

import com.ada.projeto_final.domain.dados_refinados.*;
import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.enums.GeneroEnum;
import com.ada.projeto_final.service.FlixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flix")
public class FlixResource {

    @Autowired
    private FlixService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarFilme(@RequestBody FilmeDTO filmeDto) {
        service.cadastrarFilme(filmeDto);
        return ResponseEntity.ok("Filme cadastrado com sucesso");
    }

    @PostMapping("/avaliar-filme")
    public ResponseEntity<String> avaliarFilme(@RequestBody AvaliarFilmeDTO avaliarFilmeDTO) {
        service.avaliarFilme(avaliarFilmeDTO);
        return ResponseEntity.ok("Filme avaliado com sucesso");
    }

    @GetMapping("/top-filmes-por-genero")
    public ResponseEntity<List<TopFilmesPorGenero>> topFilmesPorGenero(@RequestParam GeneroEnum genero) {
        return ResponseEntity.ok(service.topFilmesMaisPopulares(genero));
    }

    @GetMapping("/nota-media-por-faixa-etaria")
    public ResponseEntity<List<NotaMediaPorFaixaEtaria>> notaMediaPorFaixaEtariaDto(@RequestParam String titulo) {
        return ResponseEntity.ok(service.notaMediaPorFaixaEtarias(titulo));
    }

    @GetMapping("/numero-avaliacoes-por-pais")
    public ResponseEntity<List<NumeroAvaliacoesPorPais>> numeroAvaliacoesPorPais(@RequestParam String titulo) {
        return ResponseEntity.ok(service.numeroAvaliacoesPorPais(titulo));
    }
}
