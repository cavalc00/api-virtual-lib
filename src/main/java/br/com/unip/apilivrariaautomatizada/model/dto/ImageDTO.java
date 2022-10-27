package br.com.unip.apilivrariaautomatizada.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ImageDTO {

    private Long id;

    private Blob imagem;
}
