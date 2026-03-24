package dev.kaled.gestao_custos.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.kaled.gestao_custos.custom_messages.ErrorMessage;
import dev.kaled.gestao_custos.entity.Despesa;
import dev.kaled.gestao_custos.useCases.BuscarDespesaUseCase;
import dev.kaled.gestao_custos.useCases.CadastroDespesaUseCase;

@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {

    /*
     * - Cadastro de despesas
     * - criar tabela
     * - entidade
     */

    @Autowired
    CadastroDespesaUseCase cadastroDespesaUseCase;

    @Autowired
    BuscarDespesaUseCase buscarDespesaUseCase;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Despesa despesa) {
        try {
            var result = cadastroDespesaUseCase.execute(despesa);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            var errorMessage = new ErrorMessage(e.getMessage(), "INVALID_PARAMS");
            return ResponseEntity.status(400).body(errorMessage);
        }
    }

    @GetMapping("/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email,
            @RequestParam(required = false) LocalDate data) {
                return buscarDespesaUseCase.execute(email, data);
    }

    
}
