package com.winy.gestao_academica.controllers;

import com.winy.gestao_academica.infrastructure.dtos.request.DisciplinaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.DisciplinaResponseDTO;
import com.winy.gestao_academica.services.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> createDisciplina(@RequestBody DisciplinaRequestDTO disciplinaDTO) {
        disciplinaService.criarDisciplina(disciplinaDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> getDisciplinaById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(disciplinaService.findDisciplinaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplinaById(@PathVariable(name = "id") Long id) {
        disciplinaService.deleteDisciplinaById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<DisciplinaResponseDTO> changeDisciplinaBy(@RequestParam(name = "id") Long id,
                                             @RequestBody DisciplinaRequestDTO disciplinaDTO) {
        disciplinaService.changeDisciplinaById(id, disciplinaDTO);

        return ResponseEntity.ok().build();
    }
}
