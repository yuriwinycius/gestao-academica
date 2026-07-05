package com.winy.gestao_academica.infrastructure.dtos.request;

import java.util.List;

public record MatriculaRequestDTO(List<Long> disciplinasCursando) {
}
