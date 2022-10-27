package br.com.unip.apilivrariaautomatizada.controller;

import br.com.unip.apilivrariaautomatizada.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locacao")
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping("/{livroId}")
    public ResponseEntity<String> registerNewTenancy(@PathVariable("livroId") Long livroId, @RequestParam String userLogin) {
        String newTenancy = locacaoService.registerNewTenancy(livroId, userLogin);
        return ResponseEntity.ok(newTenancy);
    }

}
