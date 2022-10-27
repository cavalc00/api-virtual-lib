package br.com.unip.apilivrariaautomatizada.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PerfilEnum {

    ADMIN(1L),
    USER(2L);

    private final Long id;

}
