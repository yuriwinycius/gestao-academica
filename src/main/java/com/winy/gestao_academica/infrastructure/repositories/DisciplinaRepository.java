package com.winy.gestao_academica.infrastructure.repositories;

import com.winy.gestao_academica.infrastructure.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
