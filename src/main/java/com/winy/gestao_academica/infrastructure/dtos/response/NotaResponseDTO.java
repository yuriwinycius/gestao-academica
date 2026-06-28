package com.winy.gestao_academica.infrastructure.dtos.response;

import java.math.BigDecimal;

public record NotaResponseDTO(Long id ,BigDecimal valor, Long alunoId, Long disciplinaId) {
}
