package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.interfaces.IUsuarioGateway;
import com.fiap.postech_reserva_restaurantes.valueobjects.Cpf;

class CriarUsuarioUseCaseTest {

    @Mock
    private IUsuarioGateway usuarioGateway;

    @InjectMocks
    private CriarUsuarioUseCase criarUsuarioUseCase;

    private UsuarioEntity usuarioMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuarioMock = new UsuarioEntity(
                "TEMP_ID",
                "Carlos",
                new Cpf("98765432100"),
                LocalDate.of(1985, 3, 15),
                "11988887777",
                new EnderecoEntity(
                        "Rua Central",
                        "123",
                        "Casa",
                        "Bairro Alto",
                        "Campinas",
                        "13000-000",
                        "13000000"
                )
        );
    }

    @Test
    void deveCriarUsuarioComSucesso() {
        when(usuarioGateway.buscarPorCpf(usuarioMock.getCpf())).thenReturn(Optional.empty());
        when(usuarioGateway.salvar(any(UsuarioEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UsuarioEntity criado = criarUsuarioUseCase.executar(usuarioMock);

        assertNotNull(criado);
        assertEquals("Carlos", criado.getNome());
        assertNotEquals("TEMP_ID", criado.getId());
        verify(usuarioGateway).salvar(any(UsuarioEntity.class));
    }

    @Test
    void naoDeveCriarUsuarioSeCpfJaExistir() {
        when(usuarioGateway.buscarPorCpf(usuarioMock.getCpf())).thenReturn(Optional.of(usuarioMock));

        IllegalStateException excecao = assertThrows(IllegalStateException.class, ()
                -> criarUsuarioUseCase.executar(usuarioMock)
        );

        assertEquals("Já existe um usuário com este CPF.", excecao.getMessage());
        verify(usuarioGateway, never()).salvar(any());
    }
}
