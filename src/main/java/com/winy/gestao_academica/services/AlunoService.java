package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.entities.Aluno;
import com.winy.gestao_academica.infrastructure.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Aluno findAlunoById(Long id) {
        return alunoRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Aluno não encontrado por id: " + id));
    }

    @Transactional
    public void deleteAlunoById(Long id) {
        alunoRepository.deleteById(id);
    }

    public void changeAlunoById(Long id, Aluno aluno) {
        Aluno novoAluno = findAlunoById(id);
        aluno.setId(novoAluno.getId());

        alunoRepository.save(aluno);
    }
}
