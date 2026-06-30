package com.winy.gestao_academica.controllers;

import com.winy.gestao_academica.infrastructure.dtos.request.MatriculaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.MatriculaResponseDTO;
import com.winy.gestao_academica.services.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> createMatricula(@RequestBody MatriculaRequestDTO matriculaRequestDTO) {
        matriculaService.criarMatricula(matriculaRequestDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> getMatriculaById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(matriculaService.findMatriculaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatriculaById(@PathVariable(name = "id") Long id) {
        matriculaService.deleteMatriculaById(id);

        return ResponseEntity.ok().build();
    }

}
