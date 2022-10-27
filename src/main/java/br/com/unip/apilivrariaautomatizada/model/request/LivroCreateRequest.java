package br.com.unip.apilivrariaautomatizada.model.request;

import br.com.unip.apilivrariaautomatizada.model.dto.GeneroLivroDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LivroCreateRequest {

    @NotBlank(message = "Titulo necessário.")
    private String titulo;

    @NotNull(message = "Genero necessário.")
    private GeneroLivroDTO generoLivro;

    private String resumo;

    @NotBlank(message = "Autor necessário.")
    private String autor;

    private String editora;

    @NotNull(message = "Ano necessário.")
    private Integer anoLancamento;

    @NotNull(message = "Flag necessária.")
    private Boolean flagDisponivel;

    private String capa;

}
