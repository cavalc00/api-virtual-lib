package br.com.unip.apilivrariaautomatizada.mapper;

import br.com.unip.apilivrariaautomatizada.model.entity.GeneroLivro;
import br.com.unip.apilivrariaautomatizada.model.response.GeneroLivroResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroLivroMapper {


    List<GeneroLivroResponse> toListReponse(List<GeneroLivro> source);
}
