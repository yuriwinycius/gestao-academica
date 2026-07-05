package com.winy.gestao_academica.infrastructure.dtos.response;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record MatriculaResponseDTO(Long id, Long alunoId, List<Long> disciplinasCursando, Set<Long> disciplinasRealizadas, LocalDate dataMatricula) {
}
