package com.projectpatterns.crud;

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @MayToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @MayToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(nullable = false)
    private LocalDate data_emprestimo;

    @Column(nullable = false)
    private LocalDate data_devolucao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEmprestimo status;

    @Column(nullable = true)
    private String observacao;
}