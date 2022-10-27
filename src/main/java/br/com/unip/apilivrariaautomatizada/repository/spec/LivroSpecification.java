package br.com.unip.apilivrariaautomatizada.repository.spec;

import br.com.unip.apilivrariaautomatizada.model.entity.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class LivroSpecification implements Specification<Livro> {

    private final Long idGeneroLivro;

    private final String nomeLivro;

    @Override
    public Predicate toPredicate(Root<Livro> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (idGeneroLivro != null) {
            predicates.add(criteriaBuilder.equal(root.get("generoLivro").get("id"), idGeneroLivro));
        }

        if (Objects.nonNull(nomeLivro) && !nomeLivro.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("titulo"), "%" + nomeLivro + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
