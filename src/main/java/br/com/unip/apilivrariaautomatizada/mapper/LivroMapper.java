package br.com.unip.apilivrariaautomatizada.mapper;

import br.com.unip.apilivrariaautomatizada.model.request.LivroUpdateRequest;
import br.com.unip.apilivrariaautomatizada.model.entity.Livro;
import br.com.unip.apilivrariaautomatizada.model.response.LivroResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LivroMapper {

    void toLivro(@MappingTarget Livro target, LivroUpdateRequest source);

    LivroResponse toLivroResponse(Livro source);

    List<LivroResponse> toLivroResponseList(List<Livro> source);
}
