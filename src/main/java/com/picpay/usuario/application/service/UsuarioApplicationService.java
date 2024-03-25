package com.picpay.usuario.application.service;

import com.picpay.usuario.application.api.UsuarioRequest;
import com.picpay.usuario.application.api.UsuarioResponse;
import com.picpay.usuario.dominio.Usuario;
import com.picpay.usuario.infra.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
