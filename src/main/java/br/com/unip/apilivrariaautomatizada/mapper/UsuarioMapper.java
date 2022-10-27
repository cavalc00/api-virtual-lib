package br.com.unip.apilivrariaautomatizada.mapper;

import br.com.unip.apilivrariaautomatizada.model.entity.Usuario;
import br.com.unip.apilivrariaautomatizada.model.response.UsuarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UsuarioMapper {

    @Mapping(target = "name", source = "nome")
    @Mapping(target = "role", source = "perfis")
    UsuarioResponse toResponse(Usuario user);
}
