package com.aep.ecoconnect.service;

import com.aep.ecoconnect.model.PontoColeta;
import com.aep.ecoconnect.repository.PontoColetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontoColetaService {

    private final PontoColetaRepository repository;

    public PontoColetaService(PontoColetaRepository repository) {
        this.repository = repository;
    }

    public PontoColeta salvar(PontoColeta ponto) {
        if (ponto.getNome() == null || ponto.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do ponto de coleta não pode ser vazio.");
        }
        return repository.save(ponto);
    }

    public List<PontoColeta> listarTodos() {
        return repository.findAll();
    }

    public Optional<PontoColeta> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }
}