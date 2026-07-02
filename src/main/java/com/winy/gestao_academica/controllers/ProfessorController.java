package com.winy.gestao_academica.controllers;

import com.winy.gestao_academica.infrastructure.dtos.request.ProfessorRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.ProfessorResponseDTO;
import com.winy.gestao_academica.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> createProfessor(@RequestBody ProfessorRequestDTO professorRequestDTO) {

        professorService.criarProfessor(professorRequestDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/id")
    public ResponseEntity<ProfessorResponseDTO> findProfessorById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(professorService.findprofessorById(id));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteProfessorById(@PathVariable(name = "id") Long id) {

        professorService.deleteProfessorById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProfessorResponseDTO> changeProfessorById(@RequestParam(name = 'id') Long id,
                                                                    @RequestBody ProfessorRequestDTO professorRequestDTO) {

        professorService.changeProfessorById(id, professorRequestDTO);

        return ResponseEntity.ok().build();
    }
}
