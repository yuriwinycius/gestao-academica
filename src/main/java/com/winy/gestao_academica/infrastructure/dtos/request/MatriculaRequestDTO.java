package com.winy.gestao_academica.infrastructure.dtos.request;

import java.util.Set;

public record MatriculaRequestDTO(Set<Long> disciplinasCursando) {
}
