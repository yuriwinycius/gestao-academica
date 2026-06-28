package com.winy.gestao_academica.infrastructure.dtos.response;

import java.util.Set;

public record DisciplinaResponseDTO(Long id, String nome, Integer cargaHoraria, Set<Long> preRequisistos, Long professorId){
}
