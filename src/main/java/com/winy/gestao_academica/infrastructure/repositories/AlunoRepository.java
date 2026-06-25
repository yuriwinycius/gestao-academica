package com.winy.gestao_academica.infrastructure.repositories;

import com.winy.gestao_academica.infrastructure.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
