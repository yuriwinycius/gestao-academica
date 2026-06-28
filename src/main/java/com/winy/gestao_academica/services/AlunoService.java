package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.AlunoRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Aluno;
import com.winy.gestao_academica.infrastructure.mappers.AlunoMapper;
import com.winy.gestao_academica.infrastructure.repositories.AlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO) {
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        alunoRepository.save(aluno);

        return alunoMapper.toResponseDTO(aluno);
    }

    public AlunoResponseDTO findAlunoById(Long id) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Aluno não encontrado por id: " + id));

        return alunoMapper.toResponseDTO(aluno);
    }

    @Transactional
    public void deleteAlunoById(Long id) {
        alunoRepository.deleteById(id);
    }

    public AlunoResponseDTO changeAlunoById(Long id, AlunoRequestDTO alunoDTO) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("Aluno não encontrado por id: " + id));

        aluno.setNome(alunoDTO.nome());
        aluno.setEmail(alunoDTO.email());

        Aluno alunoAtualizado = alunoRepository.save(aluno);

        return alunoMapper.toResponseDTO(alunoAtualizado);
    }
}
