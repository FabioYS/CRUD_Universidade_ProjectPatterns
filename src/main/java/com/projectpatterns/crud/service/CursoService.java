package com.projectpatterns.crud.service;

import com.projectpatterns.crud.model.Curso;
import com.projectpatterns.crud.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso registrar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deletar(Long id) {
        cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + id));
        cursoRepository.deleteById(id);
    }
}
