package com.winy.gestao_academica.infrastructure.repositories;

import com.winy.gestao_academica.infrastructure.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
