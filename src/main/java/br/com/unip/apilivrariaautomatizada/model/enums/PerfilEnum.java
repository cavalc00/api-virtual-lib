package br.com.unip.apilivrariaautomatizada.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PerfilEnum {

    ADMIN(4L),
    USER(14L);

    private final Long id;

}
