package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

class BuscarUsuarioUseCaseTest {

    @Mock
    private IUsuarioGateway usuarioGateway;

    @InjectMocks
    private BuscarUsuarioUseCase buscarUsuarioUseCase;

    private UsuarioEntity usuarioMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuarioMock = new UsuarioEntity(
                "1",
                "Amanda",
                new Cpf("99999999999"),
                LocalDate.of(1992, 12, 1),
                "11912345678",
                new EnderecoEntity(
                        "Rua da Alegria",
                        "10",
                        "Centro",
                        "Curitiba",
                        "PR",
                        "80000-000",
                        "Casa"
                )
        );
    }

    @Test
    void deveBuscarUsuarioPorId() {
        when(usuarioGateway.buscarPorId("1")).thenReturn(Optional.of(usuarioMock));

        Optional<UsuarioEntity> resultado = buscarUsuarioUseCase.buscarPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("Amanda", resultado.get().getNome());
        verify(usuarioGateway).buscarPorId("1");
    }

    @Test
    void deveRetornarVazioAoBuscarUsuarioPorIdInexistente() {
        when(usuarioGateway.buscarPorId("999")).thenReturn(Optional.empty());

        Optional<UsuarioEntity> resultado = buscarUsuarioUseCase.buscarPorId("999");

        assertTrue(resultado.isEmpty());
        verify(usuarioGateway).buscarPorId("999");
    }

    @Test
    void deveBuscarUsuarioPorCpf() {
        when(usuarioGateway.buscarPorCpf(new Cpf("99999999999"))).thenReturn(Optional.of(usuarioMock));

        Optional<UsuarioEntity> resultado = buscarUsuarioUseCase.buscarPorCpf("99999999999");

        assertTrue(resultado.isPresent());
        assertEquals("Amanda", resultado.get().getNome());
        verify(usuarioGateway).buscarPorCpf(new Cpf("99999999999"));
    }

    @Test
    void deveRetornarVazioAoBuscarUsuarioPorCpfInexistente() {
        when(usuarioGateway.buscarPorCpf(new Cpf("00000000000"))).thenReturn(Optional.empty());

        Optional<UsuarioEntity> resultado = buscarUsuarioUseCase.buscarPorCpf("00000000000");

        assertTrue(resultado.isEmpty());
        verify(usuarioGateway).buscarPorCpf(new Cpf("00000000000"));
    }
}
