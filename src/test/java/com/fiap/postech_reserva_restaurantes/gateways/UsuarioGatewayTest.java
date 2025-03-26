package com.fiap.postech_reserva_restaurantes.gateways;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.external.repositories.UsuarioRepository;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

class UsuarioGatewayTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioGateway usuarioGateway;

    private UsuarioEntity usuarioMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuarioMock = new UsuarioEntity(
                "1",
                "Maria",
                new Cpf("12345678900"),
                LocalDate.of(1990, 5, 20),
                "11999999999",
                new EnderecoEntity(
                        "Rua Exemplo",
                        "100",
                        "Apto 10",
                        "Bairro Central",
                        "São Paulo",
                        "13000-000",
                        "01000000"
                )
        );
    }

    @Test
    void deveSalvarUsuario() {
        when(usuarioRepository.save(usuarioMock)).thenReturn(usuarioMock);

        UsuarioEntity salvo = usuarioGateway.salvar(usuarioMock);

        assertNotNull(salvo);
        assertEquals("Maria", salvo.getNome());
        verify(usuarioRepository).save(usuarioMock);
    }

    @Test
    void deveBuscarUsuarioPorId() {
        when(usuarioRepository.findById("1")).thenReturn(Optional.of(usuarioMock));

        Optional<UsuarioEntity> resultado = usuarioGateway.buscarPorId("1");

        assertTrue(resultado.isPresent());
        assertEquals("Maria", resultado.get().getNome());
    }

    @Test
    void deveBuscarUsuarioPorCpf() {
        when(usuarioRepository.findByCpf("12345678900")).thenReturn(Optional.of(usuarioMock));

        Optional<UsuarioEntity> resultado = usuarioGateway.buscarPorCpf(new Cpf("12345678900"));

        assertTrue(resultado.isPresent());
        assertEquals("12345678900", resultado.get().getCpf().getValue());
    }

    @Test
    void deveListarTodosUsuarios() {
        when(usuarioRepository.findAll()).thenReturn(List.of(usuarioMock));

        List<UsuarioEntity> usuarios = usuarioGateway.listarTodos();

        assertEquals(1, usuarios.size());
        verify(usuarioRepository).findAll();
    }

    @Test
    void deveRemoverUsuarioExistente() {
        when(usuarioRepository.existsById("1")).thenReturn(true);

        boolean removido = usuarioGateway.remover("1");

        assertTrue(removido);
        verify(usuarioRepository).deleteById("1");
    }

    @Test
    void naoDeveRemoverUsuarioInexistente() {
        when(usuarioRepository.existsById("999")).thenReturn(false);

        boolean removido = usuarioGateway.remover("999");

        assertFalse(removido);
        verify(usuarioRepository, never()).deleteById("999");
    }
}
