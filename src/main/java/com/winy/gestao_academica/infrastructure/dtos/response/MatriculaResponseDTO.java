package com.winy.gestao_academica.infrastructure.dtos.response;

import java.time.LocalDate;

public record MatriculaResponseDTO(Long id, Long alunoId, Long disciplinaId, LocalDate dataMatricula) {
}
