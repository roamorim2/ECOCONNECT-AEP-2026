package com.aep.ecoconnect.controller;

import com.aep.ecoconnect.model.PontoColeta;
import com.aep.ecoconnect.service.PontoColetaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pontos")
public class PontoColetaController {

    private final PontoColetaService service;

    public PontoColetaController(PontoColetaService service) {
        this.service = service;
    }

    @PostMapping
    public PontoColeta criar(@RequestBody PontoColeta ponto) {
        return service.salvar(ponto);
    }

    @GetMapping
    public List<PontoColeta> listar() {
        return service.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}