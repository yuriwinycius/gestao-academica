package com.winy.gestao_academica.controllers;

import com.winy.gestao_academica.infrastructure.dtos.request.NotaRequestDTO;
import com.winy.gestao_academica.infrastructure.dtos.response.NotaResponseDTO;
import com.winy.gestao_academica.services.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<NotaResponseDTO> createNota(@RequestBody NotaRequestDTO notaRequestDTO,
                                                      @RequestParam("alunoId") Long alunoId,
                                                      @RequestParam("disciplinaId") Long disciplinaId) {

        notaService.criarNota(notaRequestDTO, alunoId, disciplinaId);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/id")
    public ResponseEntity<NotaResponseDTO> findNotaById(@RequestParam("id") Long id) {

        return ResponseEntity.ok(notaService.findNotaById(id));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteNotaById(@RequestParam("id") Long id) {

        notaService.deleteNotaById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<NotaResponseDTO> changeNotaById(@RequestParam("id")Long id,
                                                          @RequestBody NotaRequestDTO notaRequestDTO) {

        notaService.changeNotaById(id, notaRequestDTO);

        return ResponseEntity.ok().build();
    }
}
