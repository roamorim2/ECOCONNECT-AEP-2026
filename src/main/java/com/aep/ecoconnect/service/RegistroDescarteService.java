package com.aep.ecoconnect.service;

import com.aep.ecoconnect.model.RegistroDescarte;
import com.aep.ecoconnect.repository.PontoColetaRepository;
import com.aep.ecoconnect.repository.RegistroDescarteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDescarteService {

    private final RegistroDescarteRepository registroDescarteRepository;
    private final PontoColetaRepository pontoColetaRepository;

    public RegistroDescarteService(RegistroDescarteRepository registroDescarteRepository,
                                   PontoColetaRepository pontoColetaRepository) {
        this.registroDescarteRepository = registroDescarteRepository;
        this.pontoColetaRepository = pontoColetaRepository;
    }

    public RegistroDescarte registrarDescarte(RegistroDescarte registro) {
        if (registro.getPontoColetaId() == null || !pontoColetaRepository.existsById(registro.getPontoColetaId())) {
            throw new IllegalArgumentException("Ponto de coleta não encontrado para o ID informado.");
        }
        return registroDescarteRepository.save(registro);
    }

    public List<RegistroDescarte> listarTodos() {
        return registroDescarteRepository.findAll();
    }

    public List<RegistroDescarte> listarPorPontoColeta(String pontoColetaId) {
        return registroDescarteRepository.findByPontoColetaId(pontoColetaId);
    }

    public void deletar(String id) {
        registroDescarteRepository.deleteById(id);
    }
}