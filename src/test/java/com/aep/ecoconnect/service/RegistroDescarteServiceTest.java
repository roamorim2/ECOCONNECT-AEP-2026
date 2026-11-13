package com.aep.ecoconnect.service;

import com.aep.ecoconnect.model.PontoColeta;
import com.aep.ecoconnect.model.RegistroDescarte;
import com.aep.ecoconnect.repository.PontoColetaRepository;
import com.aep.ecoconnect.repository.RegistroDescarteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistroDescarteServiceTest {

    @Autowired
    private RegistroDescarteService registroDescarteService;

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    @Autowired
    private RegistroDescarteRepository registroDescarteRepository;

    @Test
    void deveRegistrarDescarteComSucesso() {

        PontoColeta ponto = new PontoColeta();
        ponto.setNome("Ponto Reciclagem Sul");
        ponto.setEndereco("Av. Brasil, 500");
        PontoColeta pontoSalvo = pontoColetaRepository.save(ponto);

        RegistroDescarte registro = new RegistroDescarte();
        registro.setTipoMaterial("Plástico");
        registro.setQuantidadeKg(15.5);
        registro.setPontoColeta(pontoSalvo);

        RegistroDescarte salvo = registroDescarteService.registrarDescarte(registro);

        assertNotNull(salvo.getId());
        assertEquals("Plástico", salvo.getTipoMaterial());
        assertEquals(15.5, salvo.getQuantidadeKg());
        assertNotNull(salvo.getPontoColeta());


        List<RegistroDescarte> todos = registroDescarteService.listarTodos();
        assertFalse(todos.isEmpty());
    }
}