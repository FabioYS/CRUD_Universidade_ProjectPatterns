package com.projectpatterns.crud.repository;

import com.projectpatterns.crud.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository 
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findById(Long id);
}