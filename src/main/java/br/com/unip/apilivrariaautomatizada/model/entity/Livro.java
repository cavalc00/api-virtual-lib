package br.com.unip.apilivrariaautomatizada.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdLivro")
    private Long id;

    @JoinColumn(name = "IdGenero", referencedColumnName = "IdGenero", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GeneroLivro generoLivro;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Editora")
    private String editora;

    @Column(name = "Ano")
    private Integer anoLancamento;

    @Column(name = "Resumo", columnDefinition = "TEXT")
    private String resumo;

    @Column(name = "FlagDisponivel")
    private Boolean flagDisponivel;
}
