package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.DisciplinaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.DisciplinaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Disciplina;
import com.winy.gestao_academica.infrastructure.mappers.DisciplinaMapper;
import com.winy.gestao_academica.infrastructure.repositories.DisciplinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaMapper disciplinaMapper;

    public DisciplinaResponseDTO criarDisciplina(DisciplinaRequestDTO disciplinaRequestDTO) {

        Disciplina disciplina = disciplinaMapper.toEntity(disciplinaRequestDTO);

        disciplinaRepository.save(disciplina);
       
        return disciplinaMapper.toResponseDTO(disciplina);
    }

    public DisciplinaResponseDTO findDisciplinaById(Long id) {

        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Disciplina não encontrada por id: " + id));

        return disciplinaMapper.toResponseDTO(disciplina);
    }
    
    @Transactional
    public void deleteDisciplinaById(Long id) {
        disciplinaRepository.deleteById(id);
    }

    public DisciplinaResponseDTO changeDisciplinaById(Long id, DisciplinaRequestDTO disciplinaDTO) {

        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("Disciplina não encontrada por id: " + id));

        disciplina.setNome(disciplinaDTO.nome());
        disciplina.setPreRequisistos(disciplinaDTO.preRequisistos());
        disciplina.setProfessorId(disciplinaDTO.professorId());
        disciplina.setCargaHoraria(disciplinaDTO.cargaHoraria());

        Disciplina disciplinaAtualizada = disciplinaRepository.save(disciplina);

        return disciplinaMapper.toResponseDTO(disciplinaAtualizada);
    }
}
