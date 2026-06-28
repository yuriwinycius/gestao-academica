package com.winy.gestao_academica.infrastructure.mappers;

import com.winy.gestao_academica.infrastructure.dtos.request.ProfessorRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.ProfessorResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Professor;
import org.apache.coyote.Response;

public class ProfessorMapper {

    public Professor toEntity(ProfessorRequestDTO dto) {

        Professor professor = new Professor();

        professor.setNome(dto.nome());
        professor.setEmail(dto.email());
        professor.setEspecialidade(dto.especialidade());

        return professor;
    }

    public ProfessorResponseDTO toResponseDTO(Professor professor) {

        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail()
                );
    }
}
