package com.winy.gestao_academica.infrastructure.repositories;

import com.winy.gestao_academica.infrastructure.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
