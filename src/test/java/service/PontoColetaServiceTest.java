package com.aep.ecoconnect.service;

import com.aep.ecoconnect.model.PontoColeta;
import com.aep.ecoconnect.repository.PontoColetaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PontoColetaServiceTest {

    private PontoColetaRepository repository;
    private PontoColetaService service;

    @BeforeEach
    void setUp() {
        repository = mock(PontoColetaRepository.class);
        service = new PontoColetaService(repository);
    }

    @Test
    void deveSalvarPontoComSucesso() {
        PontoColeta ponto = new PontoColeta("1", "Ponto Centro", "Eletronicos", "Rua A, 123", "500");
        when(repository.save(any(PontoColeta.class))).thenReturn(ponto);

        PontoColeta resultado = service.salvar(ponto);

        assertNotNull(resultado);
        assertEquals("Ponto Centro", resultado.getNome());
        verify(repository, times(1)).save(ponto);
    }

    @Test
    void deveLancarExcecaoQuandoNomeForVazio() {
        PontoColeta ponto = new PontoColeta("1", "", "Eletronicos", "Rua A, 123", "500");

        assertThrows(IllegalArgumentException.class, () -> service.salvar(ponto));
        verify(repository, never()).save(any());
    }

    @Test
    void deveListarTodosOsPontos() {
        PontoColeta ponto = new PontoColeta("1", "Ponto Centro", "Eletronicos", "Rua A, 123", "500");
        when(repository.findAll()).thenReturn(List.of(ponto));

        List<PontoColeta> resultados = service.listarTodos();

        assertEquals(1, resultados.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveBuscarPorId() {
        PontoColeta ponto = new PontoColeta("1", "Ponto Centro", "Eletronicos", "Rua A, 123", "500");
        when(repository.findById("1")).thenReturn(Optional.of(ponto));

        Optional<PontoColeta> resultado = service.buscarPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("Ponto Centro", resultado.get().getNome());
    }

    @Test
    void deveDeletarPontoPorId() {
        doNothing().when(repository).deleteById("1");

        service.deletar("1");

        verify(repository, times(1)).deleteById("1");
    }
}