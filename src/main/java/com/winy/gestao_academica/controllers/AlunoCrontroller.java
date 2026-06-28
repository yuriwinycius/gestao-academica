package com.winy.gestao_academica.controllers;


import com.winy.gestao_academica.infrastructure.dtos.request.AlunoRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.AlunoResponseDTO;
import com.winy.gestao_academica.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoCrontroller {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> createAluno(@RequestBody AlunoRequestDTO alunoDTO) {
        alunoService.criarAluno(alunoDTO);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> getAlunoById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(alunoService.findAlunoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlunoById(@PathVariable(name = "id") Long id) {
        alunoService.deleteAlunoById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<AlunoResponseDTO> changeAlunoBy(@RequestParam(name = "id") Long id,
                                             @RequestBody AlunoRequestDTO alunoDTO) {
        alunoService.changeAlunoById(id, alunoDTO);

        return ResponseEntity.ok().build();
    }
}
