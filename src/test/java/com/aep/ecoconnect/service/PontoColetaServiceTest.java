package com.aep.ecoconnect.service;

import com.aep.ecoconnect.model.PontoColeta;
import com.aep.ecoconnect.repository.PontoColetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PontoColetaServiceTest {

    @Autowired
    private PontoColetaService pontoColetaService;

    @Autowired
    private PontoColetaRepository pontoColetaRepository;

    @Test
    void deveSalvarEPesquisarPontoColeta() {
        PontoColeta ponto = new PontoColeta();
        ponto.setNome("Ponto Eco Central");
        ponto.setEndereco("Rua Verde, 100");

        PontoColeta salvo = pontoColetaService.salvar(ponto);
        assertNotNull(salvo.getId());

        var encontrado = pontoColetaService.buscarPorId(salvo.getId());
        assertTrue(encontrado.isPresent());
        assertEquals("Ponto Eco Central", encontrado.get().getNome());
    }
}