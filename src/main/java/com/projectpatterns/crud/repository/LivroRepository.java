package com.projectpatterns.crud.repository;

import com.projectpatterns.crud.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository 
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<livro> findByIsbn(String isbn);
}