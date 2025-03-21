package com.projectpatterns.crud.service;

import com.projectpatterns.crud.model.Aluno;
import com.projectpatterns.crud.model.Curso;
import com.projectpatterns.crud.model.enums.StatusAluno;
import com.projectpatterns.crud.repository.AlunoRepository;
import com.projectpatterns.crud.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
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

    // Criar um novo aluno e associá-lo a um curso
    public Aluno cadastrar(Aluno aluno, Long idCurso) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + idCurso));

        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

    // Atualizar aluno (dados básicos + curso, se informado)
    public Aluno atualizar(String cpf, Aluno alunoAtualizado, Long idCurso) {
        Aluno aluno = alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com CPF: " + cpf));

        if (idCurso != null) {
            Curso curso = cursoRepository.findById(idCurso)
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado com ID: " + idCurso));
            aluno.setCurso(curso);
        }

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setTelefone(alunoAtualizado.getTelefone());

        return alunoRepository.save(aluno);
    }

    // Atualizar status do aluno
    public Aluno atualizarStatus(String cpf, StatusAluno novoStatus) {
        Aluno aluno = alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com CPF: " + cpf));

        aluno.setStatus(novoStatus);
        return alunoRepository.save(aluno);
    }

    // Remover aluno
    public void deletar(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com CPF: " + cpf));

        alunoRepository.delete(aluno);
}

}
