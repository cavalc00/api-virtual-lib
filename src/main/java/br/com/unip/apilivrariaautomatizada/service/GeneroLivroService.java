package br.com.unip.apilivrariaautomatizada.service;

import br.com.unip.apilivrariaautomatizada.mapper.GeneroLivroMapper;
import br.com.unip.apilivrariaautomatizada.model.entity.GeneroLivro;
import br.com.unip.apilivrariaautomatizada.model.response.GeneroLivroResponse;
import br.com.unip.apilivrariaautomatizada.repository.GeneroLivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneroLivroService {

    private final GeneroLivroRepository generoLivroRepository;

    private final GeneroLivroMapper generoLivroMapper;

    public List<GeneroLivroResponse> findAll() {
        List<GeneroLivro> generoLivroList = generoLivroRepository.findAll();
        return generoLivroMapper.toListReponse(generoLivroList);
    }
}
