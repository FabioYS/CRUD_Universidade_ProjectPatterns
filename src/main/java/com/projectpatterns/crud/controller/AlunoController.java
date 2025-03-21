package com.projectpatterns.crud.controller;

import com.projectpatterns.crud.model.Aluno;
import com.projectpatterns.crud.model.enums.StatusAluno;
import com.projectpatterns.crud.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Aluno> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(alunoService.buscarPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno, @RequestParam Long idCurso) {
        return ResponseEntity.ok(alunoService.cadastrar(aluno, idCurso));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Aluno> atualizar(@PathVariable String cpf, @RequestBody Aluno aluno, @RequestParam Long idCurso) {
        return ResponseEntity.ok(alunoService.atualizar(cpf, aluno, idCurso));
    }

    @PatchMapping("/{cpf}/status")
    public ResponseEntity<Aluno> atualizarStatus(@PathVariable String cpf, @RequestParam StatusAluno status) {
        return ResponseEntity.ok(alunoService.atualizarStatus(cpf, status));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf) {
        alunoService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }
}