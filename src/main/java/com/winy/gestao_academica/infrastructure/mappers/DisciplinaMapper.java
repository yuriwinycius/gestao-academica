package com.winy.gestao_academica.infrastructure.mappers;

import com.winy.gestao_academica.infrastructure.dtos.request.DisciplinaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.DisciplinaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Disciplina;

public class DisciplinaMapper {

    public Disciplina toEntity(DisciplinaRequestDTO dto) {

        Disciplina disciplina = new Disciplina();

        disciplina.setNome(dto.nome());
        disciplina.setCargaHoraria(dto.cargaHoraria());
        disciplina.setPreRequisistos(dto.preRequisistos());

        return disciplina;
    }

    public DisciplinaResponseDTO toResponseDTO(Disciplina disciplina) {
        return new DisciplinaResponseDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getCargaHoraria(),
                disciplina.getPreRequisistos(),
                disciplina.getProfessorId()
        );
    }
}
