package com.winy.gestao_academica.infrastructure.repositories;

import com.winy.gestao_academica.infrastructure.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
