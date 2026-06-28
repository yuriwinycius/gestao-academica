package com.winy.gestao_academica.infrastructure.mappers;

import com.winy.gestao_academica.infrastructure.dtos.request.MatriculaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.MatriculaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Matricula;

public class MatriculaMapper {

    public Matricula toEntity(MatriculaRequestDTO dto) {

        Matricula matricula = new Matricula();

        matricula.setAlunoId(dto.alunoId());
        matricula.setDisciplinaId(dto.disciplinaId());

        return matricula;
    }

    public MatriculaResponseDTO toResponseDTO(Matricula matricula) {

        return new MatriculaResponseDTO(
                matricula.getId(),
                matricula.getAlunoId(),
                matricula.getDisciplinaId(),
                matricula.getDataMatricula()
        );
    }
}
