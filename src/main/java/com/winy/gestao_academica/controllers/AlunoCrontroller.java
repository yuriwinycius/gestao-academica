package com.winy.gestao_academica.controllers;


import com.winy.gestao_academica.infrastructure.entities.Aluno;
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
    public ResponseEntity<Void> createAluno(@RequestBody Aluno aluno) {
        alunoService.criarAluno(aluno);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(alunoService.findAlunoById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlunoById(@PathVariable(name = "id") Long id) {
        alunoService.deleteAlunoById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> changeAlunoBy(@RequestParam(name = "id") Long id,
                                             @RequestBody Aluno aluno) {
        alunoService.changeAlunoById(id, aluno);

        return ResponseEntity.ok().build();
    }
}
