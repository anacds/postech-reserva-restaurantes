package com.fiap.postech_reserva_restaurantes.controller;

import com.fiap.postech_reserva_restaurantes.dto.UsuarioDTO;
import com.fiap.postech_reserva_restaurantes.entities.UsuarioEntity;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.AtualizarUsuarioUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.BuscarUsuarioUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.ListarUsuariosUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.CriarUsuarioUseCase;
import com.fiap.postech_reserva_restaurantes.usecases.usuario.RemoverUsuarioUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final AtualizarUsuarioUseCase atualizarUsuarioUseCase;
    private final RemoverUsuarioUseCase removerUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;


    public UsuarioController(
        CriarUsuarioUseCase criarUsuarioUseCase,
        BuscarUsuarioUseCase buscarUsuarioUseCase,
        AtualizarUsuarioUseCase atualizarUsuarioUseCase,
        RemoverUsuarioUseCase removerUsuarioUseCase,
        ListarUsuariosUseCase listarUsuariosUseCase) {
    this.criarUsuarioUseCase = criarUsuarioUseCase;
    this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    this.atualizarUsuarioUseCase = atualizarUsuarioUseCase;
    this.removerUsuarioUseCase = removerUsuarioUseCase;
    this.listarUsuariosUseCase = listarUsuariosUseCase;
}


    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioEntity> criarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = criarUsuarioUseCase.executar(
                usuarioDTO.nome(),
                usuarioDTO.cpf(),
                usuarioDTO.dataNascimento(),
                usuarioDTO.telefone(),
                usuarioDTO.endereco()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios() {
        List<UsuarioEntity> usuarios = listarUsuariosUseCase.executar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorId(@PathVariable String id) {
        Optional<UsuarioEntity> usuario = buscarUsuarioUseCase.buscarPorId(id);
        return usuario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorCpf(@PathVariable String cpf) {
        Optional<UsuarioEntity> usuario = buscarUsuarioUseCase.buscarPorCpf(cpf);
        return usuario.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioEntity> atualizarUsuario(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioEntity> atualizado = atualizarUsuarioUseCase.executar(
                id,
                usuarioDTO.nome(),
                usuarioDTO.cpf(),
                usuarioDTO.dataNascimento(),
                usuarioDTO.telefone(),
                usuarioDTO.endereco()
        );
        return atualizado.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> removerUsuario(@PathVariable String id) {
        boolean removido = removerUsuarioUseCase.executar(id);
        return removido ? ResponseEntity.noContent().build()
                        : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
