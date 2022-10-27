package br.com.unip.apilivrariaautomatizada.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {

    private String id;

    private String name;

    private String email;

    private String picture;

    private List<PerfilResponse> role;

}
