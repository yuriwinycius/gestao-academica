package com.winy.gestao_academica.infrastructure.mappers;

import com.winy.gestao_academica.infrastructure.dtos.request.AlunoRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Aluno;

public class AlunoMapper {
    public Aluno toEntity(AlunoRequestDTO dto) {

        Aluno aluno = new Aluno();

        aluno.setNome(dto.nome());
        aluno.setEmail(dto.email());

        return aluno;
    }

    public AlunoResponseDTO toResponseDTO(Aluno aluno) {

        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getMatricula()
                );
    }
}
