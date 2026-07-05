package com.winy.gestao_academica.services;

import com.winy.gestao_academica.infrastructure.dtos.request.NotaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.DisciplinaResponseDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.NotaResponseDTO;
import com.winy.gestao_academica.infrastructure.entities.Nota;
import com.winy.gestao_academica.infrastructure.mappers.NotaMapper;
import com.winy.gestao_academica.infrastructure.repositories.NotaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final NotaMapper notaMapper;

    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    public NotaResponseDTO criarNota(NotaRequestDTO notaRequestDTO,Long alunoId, Long disciplinaId) {

        AlunoResponseDTO alunoResponseDTO = alunoService.findAlunoById(alunoId);
        DisciplinaResponseDTO disciplinaResponseDTO = disciplinaService.findDisciplinaById(disciplinaId);

        Nota nota = notaMapper.toEntity(notaRequestDTO);
        nota.setAlunoId(alunoResponseDTO.id());
        nota.setDisciplinaId(disciplinaResponseDTO.id());

        return notaMapper.toResponseDTO(nota);
    }

    public NotaResponseDTO findNotaById(Long id) {

        Nota nota = notaRepository.findById(id).orElseThrow(() ->
                new NullPointerException("Nota não encontrada por id: " + id));

        return notaMapper.toResponseDTO(nota);
    }

    @Transactional
    public void deleteNotaById(Long id){
        notaRepository.deleteById(id);
    }

    public NotaResponseDTO changeNotaById(Long id, NotaRequestDTO notaRequestDTO) {

        Nota nota = notaRepository.findById(id).orElseThrow(() ->
                        new NullPointerException("Nota não encontrada por id: " + id));

        nota.setValor(notaRequestDTO.valor());

        Nota notaAtualizada = notaRepository.save(nota);

        return notaMapper.toResponseDTO(notaAtualizada);
    }
}
