package br.com.unip.apilivrariaautomatizada.repository;

import br.com.unip.apilivrariaautomatizada.model.entity.LocacaoLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoLivroRepository extends JpaRepository<LocacaoLivro, Long> {
}
