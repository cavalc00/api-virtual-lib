package br.com.unip.apilivrariaautomatizada.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GeneroLivroDTO {

    private Long id;

    private String nome;

}
