package com.projectpatterns.crud.model; // Apenas um package correto

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@Data // Inclui Getter, Setter, toString, equals, e hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Corrigido: era @MayToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne // Corrigido: era @MayToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(nullable = false)
    private LocalDate dataEmprestimo; // Corrigido: era data_emprestimo

    @Column(nullable = false)
    private LocalDate dataDevolucao; // Corrigido: era data_devolucao

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEmprestimo status;

    @Column(nullable = true)
    private String observacao;
}
