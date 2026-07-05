package com.winy.gestao_academica.infrastructure.dtos.request;

import java.util.List;

public record MatriculaRequestDTO(Long alunoId, List<Long> disciplinasCursando) {
}
