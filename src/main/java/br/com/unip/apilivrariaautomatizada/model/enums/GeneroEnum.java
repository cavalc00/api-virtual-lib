package br.com.unip.apilivrariaautomatizada.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GeneroEnum {

    FICCAO_CIENTIFICA(1L),
    FANTASIA(2L),
    DISTOPIA(3L),
    ACAO_E_AVENTURA(4L),
    HORROR(5L),
    THRILLER_E_SUSPENSE(6L),
    FICCAO_POLICIAL(7L),
    FICCAO_HISTORICA(8L),
    ROMANCE(9L),
    FICCAO_CONTEMPORANIA(10L),
    REALISMO_MAGICO(11L),
    GRAPICH_NOVEL(12L),
    CONTO(13L),
    INFANTIL(14L),
    MEMORIAS_E_AUTOBIOGRAFIA(15L),
    BIOGRAFIA(16L),
    GASTRONOMIA(17L),
    ARTE_E_FOTOGRAFIA(18L),
    AUTOAJUDA(19L),
    HISTORIA(20L),
    VIAJEM(21L),
    CRIMES_REAIS(22L),
    HUMOR(23L),
    RELIGIAO_E_ESPIRITUALIDADE(24L),
    HUMANIDADES_E_CIENCIAS_SOCIAIS(25L),
    TECNOLOGIA_E_CIENCIA(26L);

    private final Long id;
}
