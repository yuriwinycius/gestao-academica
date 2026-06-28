package com.winy.gestao_academica.infrastructure.mappers;

import com.winy.gestao_academica.infrastructure.dtos.request.NotaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.NotaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Nota;

public class NotaMapper {

    public Nota toEntity(NotaRequestDTO dto) {

        Nota nota = new Nota();

        nota.setValor(dto.valor());
        nota.setAlunoId(dto.alunoId());
        nota.setDisciplinaId(dto.disciplinaId());

        return nota;
    }

    public NotaResponseDTO toResponseDTO(Nota nota){

        return new NotaResponseDTO(
                nota.getId(),
                nota.getValor(),
                nota.getAlunoId(),
                nota.getDisciplinaId()
                );
    }
}
