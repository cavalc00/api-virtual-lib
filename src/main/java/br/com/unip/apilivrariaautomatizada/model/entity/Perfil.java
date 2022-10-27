package br.com.unip.apilivrariaautomatizada.model.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "perfil")
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPerfil")
    private Long id;

    @Column(name = "Tipo")
    private String tipo;

    @ManyToMany(mappedBy = "perfis")
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return this.tipo;
    }
}
