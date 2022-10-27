package br.com.unip.apilivrariaautomatizada.controller;

import br.com.unip.apilivrariaautomatizada.model.response.GeneroLivroResponse;
import br.com.unip.apilivrariaautomatizada.service.GeneroLivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/genero")
public class GeneroLivroController {

    private final GeneroLivroService generoLivroService;

    @GetMapping
    public ResponseEntity<List<GeneroLivroResponse>> findAll() {
        return ResponseEntity.ok(generoLivroService.findAll());
    }
}
