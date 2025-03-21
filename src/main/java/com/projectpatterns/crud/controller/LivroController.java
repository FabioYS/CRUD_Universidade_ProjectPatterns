package com.projectpatterns.crud.controller;

import com.projectpatterns.crud.model.Livro;
import com.projectpatterns.crud.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Livro> buscarPorIsbn(@PathVariable String isbn) {
        return ResponseEntity.ok(livroService.buscarPorIsbn(isbn));
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.cadastrar(livro));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Livro> atualizar(@PathVariable String isbn, @RequestBody Livro livroAtualizado) {
        return ResponseEntity.ok(livroService.atualizar(isbn, livroAtualizado));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deletar(@PathVariable String isbn) {
        livroService.deletar(isbn);
        return ResponseEntity.noContent().build();
    }
}
