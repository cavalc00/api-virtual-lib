package br.com.unip.apilivrariaautomatizada.config;

import br.com.unip.apilivrariaautomatizada.model.entity.Usuario;
import br.com.unip.apilivrariaautomatizada.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByEmail(username);
        return user.orElseThrow(
                () -> new UsernameNotFoundException("Dados inválidos!")
        );
    }
}
