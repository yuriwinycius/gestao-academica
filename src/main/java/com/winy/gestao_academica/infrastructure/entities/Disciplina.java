package com.winy.gestao_academica.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "pre_requisitos")
    private Set<Disciplina> preRequisistos;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professorId;
}
