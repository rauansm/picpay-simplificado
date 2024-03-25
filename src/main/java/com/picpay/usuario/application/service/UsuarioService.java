package com.picpay.usuario.application.service;

import com.picpay.usuario.application.api.UsuarioDetalhadoResponse;
import com.picpay.usuario.application.api.UsuarioRequest;
import com.picpay.usuario.application.api.UsuarioResponse;

import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse cadastraNovoUsuario(UsuarioRequest usuarioRequest);

    UsuarioDetalhadoResponse buscaUsuarioPorId(UUID idUsuario);
}
