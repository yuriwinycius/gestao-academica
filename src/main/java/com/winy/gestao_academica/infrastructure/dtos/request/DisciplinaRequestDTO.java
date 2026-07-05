package com.winy.gestao_academica.infrastructure.dtos.request;


import java.util.Set;

public record DisciplinaRequestDTO(String nome, Integer cargaHoraria, Set<Long> preRequisistos) {}