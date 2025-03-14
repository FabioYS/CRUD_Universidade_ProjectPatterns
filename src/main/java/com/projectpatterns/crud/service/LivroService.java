package com.projectpatterns.crud.service;

import com.projectpatterns.crud.model.Livro;
import com.projectpatterns.crud.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Livro buscarPorIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ISBN: " + isbn));
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + id));
        livroRepository.deleteById(id);
    }
}
