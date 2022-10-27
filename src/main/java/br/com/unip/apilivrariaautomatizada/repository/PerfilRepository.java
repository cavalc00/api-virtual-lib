package br.com.unip.apilivrariaautomatizada.repository;

import br.com.unip.apilivrariaautomatizada.model.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
