package com.projectpatterns.crud.service;

import com.projectpatterns.crud.model.Aluno;
import com.projectpatterns.crud.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // Buscar aluno por CPF
    public Aluno buscarPorCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com CPF: " + cpf));
    }

    // Criar um novo aluno
    public Aluno registrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Atualizar aluno
    public Aluno atualizar(String cpf, Aluno alunoAtualizado) {
        Aluno aluno = alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com CPF: " + cpf));

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setTelefone(alunoAtualizado.getTelefone());

        return alunoRepository.save(aluno);
    }

    // Remover aluno
    public void deletar(String cpf) {
        alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o CPF: " + cpf));
        alunoRepository.delete(aluno);
    }
}
