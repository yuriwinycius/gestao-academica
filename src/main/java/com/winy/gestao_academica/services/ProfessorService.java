package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.ProfessorRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.ProfessorResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Professor;
import com.winy.gestao_academica.infrastructure.mappers.ProfessorMapper;
import com.winy.gestao_academica.infrastructure.repositories.ProfessorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorResponseDTO criarProfessor(ProfessorRequestDTO professorRequestDTO){

        Professor professor = professorMapper.toEntity(professorRequestDTO);

        professorRepository.save(professor);

        return professorMapper.toResponseDTO(professor);
    }

    public ProfessorResponseDTO findprofessorById(Long id) {

        Professor professor = professorRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Professora(o) não encontrada(o) por id: " + id));

        return professorMapper.toResponseDTO(professor);
    }

    @Transactional
    public void deleteProfessorById(Long id) {
        professorRepository.deleteById(id);
    }

    public ProfessorResponseDTO changeProfessorById(Long id, ProfessorRequestDTO professorRequestDTO) {

        Professor professor = professorRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Professora(o) não encontrada(o) por id: " + id));

        professor.setNome(professorRequestDTO.nome());
        professor.setEmail(professorRequestDTO.email());
        professor.setEspecialidade(professorRequestDTO.especialidade());

        Professor professorAtualizado = professorRepository.save(professor);

        return professorMapper.toResponseDTO(professorAtualizado);
    }
}
