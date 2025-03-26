package com.fiap.postech_reserva_restaurantes.usecases.usuario;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class AtualizarUsuarioUseCaseTest {

    @Mock
    private IUsuarioGateway usuarioGateway;

    @InjectMocks
    private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    private UsuarioEntity usuarioExistente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuarioExistente = new UsuarioEntity(
                "1",
                "Lucas",
                new Cpf("11111111111"),
                LocalDate.of(1995, 8, 10),
                "11999999999",
                new EnderecoEntity(
                        "Rua das Flores", // rua
                        "123", // número
                        "Centro", // bairro
                        "São Paulo", // cidade
                        "SP", // estado
                        "12345-678", // cep
                        "Bloco B" // complemento
                )
        );
    }

    @Test
    void deveAtualizarUsuarioComSucesso() {
        when(usuarioGateway.buscarPorId("1")).thenReturn(Optional.of(usuarioExistente));
        when(usuarioGateway.atualizar(any(UsuarioEntity.class))).thenAnswer(i -> i.getArgument(0));

        var novoCpf = new Cpf("22222222222");
        var novoEndereco = new EnderecoEntity(
                "Rua Nova",
                "456",
                "Bairro Novo",
                "Rio de Janeiro",
                "RJ",
                "98765-432",
                "Apto 202"
        );

        var resultado = atualizarUsuarioUseCase.executar(
                "1",
                "Lucas Silva",
                novoCpf,
                LocalDate.of(1995, 8, 10),
                "11988887777",
                novoEndereco
        );

        assertTrue(resultado.isPresent());
        UsuarioEntity atualizado = resultado.get();
        assertEquals("Lucas Silva", atualizado.getNome());
        assertEquals("22222222222", atualizado.getCpf().getValue());
        assertEquals("11988887777", atualizado.getTelefone());
        assertEquals("Rua Nova", atualizado.getEndereco().getRua());
        assertEquals("98765-432", atualizado.getEndereco().getCep());
        assertEquals("RJ", atualizado.getEndereco().getEstado());

        verify(usuarioGateway).atualizar(any(UsuarioEntity.class));
    }

    @Test
    void naoDeveAtualizarUsuarioInexistente() {
        when(usuarioGateway.buscarPorId("999")).thenReturn(Optional.empty());

        var resultado = atualizarUsuarioUseCase.executar(
                "999",
                "Nome",
                new Cpf("00000000000"),
                LocalDate.now(),
                "1100000000",
                usuarioExistente.getEndereco()
        );

        assertTrue(resultado.isEmpty());
        verify(usuarioGateway, never()).atualizar(any());
    }
}
