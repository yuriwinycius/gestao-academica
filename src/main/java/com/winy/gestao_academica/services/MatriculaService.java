package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.MatriculaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.MatriculaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Matricula;
import com.winy.gestao_academica.infrastructure.mappers.MatriculaMapper;
import com.winy.gestao_academica.infrastructure.repositories.MatriculaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaService {
    
    private final MatriculaRepository matriculaRepository;
    private final MatriculaMapper matriculaMapper;
    
    public MatriculaResponseDTO criarMatricula(MatriculaRequestDTO matriculaRequestDTO) {
        
        Matricula matricula = matriculaMapper.toEntity(matriculaRequestDTO);
        
        matriculaRepository.save(matricula);
        
        return matriculaMapper.toResponseDTO(matricula);
    }
    
    public MatriculaResponseDTO findMatriculaById(Long id) {
        
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Matrícula não encontrada por id: " + id));
        
        return matriculaMapper.toResponseDTO(matricula);
    }

    @Transactional
    public void deleteMatriculaById(Long id) {
        matriculaRepository.deleteById(id);
    }

}
