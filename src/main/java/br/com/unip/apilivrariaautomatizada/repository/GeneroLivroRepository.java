package br.com.unip.apilivrariaautomatizada.repository;

import br.com.unip.apilivrariaautomatizada.model.entity.GeneroLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroLivroRepository extends JpaRepository<GeneroLivro, Long> {
}
