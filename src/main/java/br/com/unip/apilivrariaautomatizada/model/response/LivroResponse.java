package br.com.unip.apilivrariaautomatizada.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivroResponse {

    private Long id;

    private GeneroLivroResponse generoLivro;

    private String resumo;

    private String titulo;

    private String autor;

    private String editora;

    private Integer anoLancamento;

    private String imageUrl;

    private Boolean flagDisponivel;
}
