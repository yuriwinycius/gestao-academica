package com.winy.gestao_academica.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Alunos")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Long alunoId;

    @ManyToOne
    @JoinColumn(name = "disciplina_cursando")
    private List<Long> disciplinasCursando;

    @ManyToOne
    @JoinColumn(name = "disciplinas_realizadas")
    private Set<Long> disciplinasRealizadas;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula = LocalDate.now();
}
