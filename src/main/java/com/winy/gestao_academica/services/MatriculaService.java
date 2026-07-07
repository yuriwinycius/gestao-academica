package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.DisciplinaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.request.MatriculaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.DisciplinaResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.MatriculaResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.ProfessorResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Disciplina;
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
    private final AlunoService alunoService;

    private final MatriculaMapper matriculaMapper;
    
    public MatriculaResponseDTO criarMatricula(MatriculaRequestDTO matriculaRequestDTO, Long alunoId) {

        AlunoResponseDTO alunoResponseDTO = alunoService.findAlunoById(alunoId);

        Matricula matricula = matriculaMapper.toEntity(matriculaRequestDTO);
        matricula.setAlunoId(alunoResponseDTO.id());

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

    public MatriculaResponseDTO changeMatriculaById(Long id, MatriculaRequestDTO matriculaRequestDTO,
                                                      Long alunoId) {

        AlunoResponseDTO alunoResponseDTO = alunoService.findAlunoById(alunoId);

        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() ->
                        new NullPointerException("Matricula não encontrada por id: " + id));

        matricula.setDisciplinasCursando(matriculaRequestDTO.disciplinasCursando());
        matricula.setAlunoId(alunoResponseDTO.id());

        Matricula matriculaAtualiada = matriculaRepository.save(matricula);

        return matriculaMapper.toResponseDTO(matriculaAtualiada);
    }
}
