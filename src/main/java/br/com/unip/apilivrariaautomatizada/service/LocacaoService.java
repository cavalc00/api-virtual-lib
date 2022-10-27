package br.com.unip.apilivrariaautomatizada.service;

import br.com.unip.apilivrariaautomatizada.model.entity.Livro;
import br.com.unip.apilivrariaautomatizada.model.entity.LocacaoLivro;
import br.com.unip.apilivrariaautomatizada.model.entity.Usuario;
import br.com.unip.apilivrariaautomatizada.repository.LivroRepository;
import br.com.unip.apilivrariaautomatizada.repository.LocacaoLivroRepository;
import br.com.unip.apilivrariaautomatizada.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoLivroRepository locacaoLivroRepository;

    private final LivroRepository livroRepository;

    private final UsuarioRepository usuarioRepository;

    public String registerNewTenancy(Long idLivro, String userLogin) {
        Livro livro = livroRepository.findById(idLivro).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        Usuario usuario = usuarioRepository.findByEmail(userLogin).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        if (livro.getFlagDisponivel()) {
            LocacaoLivro locacaoLivro = LocacaoLivro.builder()
                    .livro(livro)
                    .usuario(usuario)
                    .dataLocado(LocalDate.now())
                    .dataDevolvido(null)
                    .build();

            LocacaoLivro locacaoLivro1 = locacaoLivroRepository.save(locacaoLivro);
            return "Livro" + livro.getTitulo() + " alugado em " + locacaoLivro1.getDataLocado().toString();
        } else {
            return "Livro" + livro.getTitulo() + " indisponivel";
        }
    }
}
