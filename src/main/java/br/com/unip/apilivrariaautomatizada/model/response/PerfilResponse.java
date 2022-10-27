package br.com.unip.apilivrariaautomatizada.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilResponse {

    private Long id;

    private String tipo;

}
