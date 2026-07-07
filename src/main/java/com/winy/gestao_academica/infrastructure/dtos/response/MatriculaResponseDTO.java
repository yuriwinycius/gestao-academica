package com.winy.gestao_academica.infrastructure.dtos.response;

import java.time.LocalDate;
import java.util.Set;

public record MatriculaResponseDTO(Long id, Long alunoId, Set<Long> disciplinasCursando, Set<Long> disciplinasRealizadas, LocalDate dataMatricula) {
}
