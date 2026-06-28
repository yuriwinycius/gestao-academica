package com.winy.gestao_academica.infrastructure.dtos.request;

import java.math.BigDecimal;

public record NotaRequestDTO(BigDecimal valor, Long alunoId, Long disciplinaId) {
}
