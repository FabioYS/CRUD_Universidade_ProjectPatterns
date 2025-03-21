package com.projectpatterns.crud.controller;

import com.projectpatterns.crud.model.Emprestimo;
import com.projectpatterns.crud.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @PostMapping("/{cpf}/{isbn}")
    public ResponseEntity<Emprestimo> registrar(@PathVariable String cpf, @PathVariable String isbn) {
        return ResponseEntity.ok(emprestimoService.registrar(cpf, isbn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizar(@PathVariable Long id, @RequestBody Emprestimo emprestimoAtualizado) {
        return ResponseEntity.ok(emprestimoService.atualizar(id, emprestimoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
