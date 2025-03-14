package com.projectpatterns.crud.service;

import com.projectpatterns.crud.model.Aluno;
import com.projectpatterns.crud.model.Emprestimo;
import com.projectpatterns.crud.repository.AlunoRepository;
import com.projectpatterns.crud.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final AlunoRepository alunoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, AlunoRepository alunoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.alunoRepository = alunoRepository;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public List<Emprestimo> listarPorAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + alunoId));
        return emprestimoRepository.findByAluno(aluno);
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public void deletar(Long id) {
        emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com ID: " + id));
        emprestimoRepository.deleteById(id);
    }
}
