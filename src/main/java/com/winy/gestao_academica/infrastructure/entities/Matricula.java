package com.winy.gestao_academica.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private Aluno alunoId;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplinaId;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;
}
