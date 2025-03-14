package com.projectpatterns.crud;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "livro")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate data_publicacao;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false)
    private String quantidade_disponivel;
}