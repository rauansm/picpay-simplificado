package com.picpay.usuario.application.service;

import com.picpay.usuario.application.api.UsuarioDetalhadoResponse;
import com.picpay.usuario.application.api.UsuarioRequest;
import com.picpay.usuario.application.api.UsuarioResponse;
import com.picpay.usuario.dominio.Usuario;
import com.picpay.usuario.infra.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Override
    public UsuarioResponse cadastraNovoUsuario(UsuarioRequest usuarioRequest) {
        log.info("[inicia] UsuarioApplicationService - cadastraNovoUsuario");
        Usuario novoUsuario = usuarioRepository.salva(new Usuario(usuarioRequest));
        log.info("[finaliza] UsuarioApplicationService - cadastraNovoUsuario");
        return new UsuarioResponse(novoUsuario);
    }

    @Override
    public UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioApplicationService - buscaUsuarioPorId");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        log.info("[finaliza] UsuarioApplicationService - buscaUsuarioPorId");
        return new UsuarioDetalhadoResponse(usuario);
    }
}
