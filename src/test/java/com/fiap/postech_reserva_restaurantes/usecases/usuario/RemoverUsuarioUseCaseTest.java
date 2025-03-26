package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;

class RemoverUsuarioUseCaseTest {

    @Mock
    private IUsuarioGateway usuarioGateway;

    @InjectMocks
    private RemoverUsuarioUseCase removerUsuarioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRemoverUsuarioComSucesso() {
        when(usuarioGateway.remover("1")).thenReturn(true);

        boolean resultado = removerUsuarioUseCase.executar("1");

        assertTrue(resultado);
        verify(usuarioGateway).remover("1");
    }

    @Test
    void deveRetornarFalsoAoTentarRemoverUsuarioInexistente() {
        when(usuarioGateway.remover("999")).thenReturn(false);

        boolean resultado = removerUsuarioUseCase.executar("999");

        assertFalse(resultado);
        verify(usuarioGateway).remover("999");
    }
}
