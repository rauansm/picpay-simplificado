package com.picpay.usuario.application.api;

import com.picpay.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
public class UsuarioController implements UsuarioAPI {
    private final UsuarioService usuarioService;
    @Override
    public UsuarioResponse cadastraNovoUsuario(UsuarioRequest usuarioRequest) {
        log.info("[inicia] UsuarioController - cadastraNovoUsuario");
        UsuarioResponse usuarioCadastrado = usuarioService.cadastraNovoUsuario(usuarioRequest);
        log.info("[finaliza] UsuarioController - cadastraNovoUsuario");
        return usuarioCadastrado;
    }

    @Override
    public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioController - buscaUsuarioPorId");
        UsuarioDetalhadoResponse usuario = usuarioService.buscaUsuarioPorId(idUsuario);
        log.info("[finaliza] UsuarioController - buscaUsuarioPorId");
        return usuario;
    }
}
