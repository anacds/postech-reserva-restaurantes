package com.fiap.postech_reserva_restaurantes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.postech_reserva_restaurantes.dto.CpfDTO;
import com.fiap.postech_reserva_restaurantes.dto.EnderecoDTO;
import com.fiap.postech_reserva_restaurantes.dto.UsuarioDTO;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UsuarioController.class)
class UsuarioControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CriarUsuarioUseCase criarUsuarioUseCase;

    @MockBean
    private BuscarUsuarioUseCase buscarUsuarioUseCase;

    @MockBean
    private AtualizarUsuarioUseCase atualizarUsuarioUseCase;

    @MockBean
    private RemoverUsuarioUseCase removerUsuarioUseCase;

    @MockBean
    private ListarUsuariosUseCase listarUsuariosUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    private UsuarioEntity usuarioMock;

    @BeforeEach
    void setUp() {
        usuarioMock = new UsuarioEntity(
                UUID.randomUUID().toString(),
                "Fernanda",
                new com.fiap.postech_reserva_restaurantes.valueobjects.Cpf("12345678900"),
                LocalDate.of(1990, 1, 1),
                "11999999999",
                new com.fiap.postech_reserva_restaurantes.entities.EnderecoEntity(
                        "Rua Teste",
                        "100",
                        "Centro",
                        "São Paulo",
                        "SP",
                        "12345-000",
                        "Apto 1"
                )
        );
    }

    @Test
    void deveCriarUsuarioComSucesso() throws Exception {
        Mockito.when(criarUsuarioUseCase.executar(any(UsuarioEntity.class))).thenReturn(usuarioMock);

        UsuarioDTO dto = new UsuarioDTO(
                usuarioMock.getNome(),
                new CpfDTO(usuarioMock.getCpf().getValue()),
                usuarioMock.getDataNascimento(),
                usuarioMock.getTelefone(),
                new EnderecoDTO(
                        usuarioMock.getEndereco().getRua(),
                        usuarioMock.getEndereco().getNumero(),
                        usuarioMock.getEndereco().getBairro(),
                        usuarioMock.getEndereco().getCidade(),
                        usuarioMock.getEndereco().getEstado(),
                        usuarioMock.getEndereco().getCep(),
                        usuarioMock.getEndereco().getComplemento()
                )
        );

        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Fernanda"))
                .andExpect(jsonPath("$.cpf.value").value("12345678900"));
    }

    @Test
    void deveBuscarUsuarioPorIdComSucesso() throws Exception {
        Mockito.when(buscarUsuarioUseCase.buscarPorId(usuarioMock.getId()))
                .thenReturn(Optional.of(usuarioMock));

        mockMvc.perform(get("/usuarios/{id}", usuarioMock.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Fernanda"));
    }

    @Test
    void deveRetornar404SeUsuarioNaoEncontrado() throws Exception {
        Mockito.when(buscarUsuarioUseCase.buscarPorId("naoExiste"))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/usuarios/{id}", "naoExiste"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveRemoverUsuarioComSucesso() throws Exception {
        Mockito.when(removerUsuarioUseCase.executar(usuarioMock.getId())).thenReturn(true);

        mockMvc.perform(delete("/usuarios/{id}", usuarioMock.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    void deveRetornar404AoTentarRemoverUsuarioInexistente() throws Exception {
        Mockito.when(removerUsuarioUseCase.executar("naoExiste")).thenReturn(false);

        mockMvc.perform(delete("/usuarios/{id}", "naoExiste"))
                .andExpect(status().isNotFound());
    }
}
