package com.projectpatterns.crud;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String matricula;

    @Column(nullable = false)
    private email;

    private telefone;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAluno status;

    @MayToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
}