package br.com.unip.apilivrariaautomatizada.service;

import br.com.unip.apilivrariaautomatizada.mapper.UsuarioMapper;
import br.com.unip.apilivrariaautomatizada.model.dto.UserDTO;
import br.com.unip.apilivrariaautomatizada.model.entity.Perfil;
import br.com.unip.apilivrariaautomatizada.model.entity.Usuario;
import br.com.unip.apilivrariaautomatizada.model.enums.PerfilEnum;
import br.com.unip.apilivrariaautomatizada.model.response.UsuarioResponse;
import br.com.unip.apilivrariaautomatizada.repository.PerfilRepository;
import br.com.unip.apilivrariaautomatizada.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final UsuarioMapper usuarioMapper;

    public boolean isAuthenticated() {
        return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    public UsuarioResponse getUser() {
        if (!isAuthenticated()) return null;
        UserDTO userDTO = (UserDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Objects.isNull(userDTO)) return null;

        Usuario user = registerNewUser(userDTO);

        return usuarioMapper.toResponse(user);
    }

    private Usuario registerNewUser(UserDTO userDTO) {

        Perfil perfil = perfilRepository.findById(PerfilEnum.USER.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        Optional<Usuario> user = usuarioRepository.findByEmail(userDTO.getUsername());

        if (user.isPresent()) return user.get();

        Usuario newUser = Usuario.builder()
                .nome(userDTO.getName())
                .email(userDTO.getUsername())
                .picture(userDTO.getPicture())
                .idGoogle(userDTO.getPassword())
                .perfis(List.of(perfil))
                .build();

        Usuario usuario = usuarioRepository.save(newUser);
        return usuario;
    }
}
