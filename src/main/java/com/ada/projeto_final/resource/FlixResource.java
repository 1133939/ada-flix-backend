package com.ada.projeto_final.resource;

import com.ada.projeto_final.dto.AvaliarFilmeDTO;
import com.ada.projeto_final.dto.FilmeDTO;
import com.ada.projeto_final.service.FlixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flix")
public class FlixResource {

    @Autowired
    private FlixService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarFilme(FilmeDTO filmeDto) {
        service.cadastrarFilme(filmeDto);
        return ResponseEntity.ok("Filme cadastrado com sucesso");
    }

    @PostMapping("/avaliar-filme")
    public ResponseEntity<String> avaliarFilme(AvaliarFilmeDTO avaliarFilmeDTO) {
        service.avaliarFilme(avaliarFilmeDTO);
        return ResponseEntity.ok("Filme avaliado com sucesso");
    }

    @GetMapping("/top-filmes-mais-populares")
    public ResponseEntity<String> topFilmesMaisPopulares() {
        return ResponseEntity.ok(service.topFilmesMaisPopulares());
    }

    @GetMapping("/genero-melhor-avaliacao-media")
    public ResponseEntity<String> generoMelhorAvaliacaoMedia() {
        return ResponseEntity.ok(service.generoMelhorAvaliacaoMedia());
    }

    @GetMapping("/pais-assiste-mais-filmes")
    public ResponseEntity<String> paisAssisteMaisFilmes() {
        return ResponseEntity.ok(service.paisAssisteMaisFilmes());
    }
}
