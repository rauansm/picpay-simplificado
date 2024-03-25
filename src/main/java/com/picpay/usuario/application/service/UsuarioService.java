package com.picpay.usuario.application.service;

import com.picpay.usuario.application.api.UsuarioRequest;
import com.picpay.usuario.application.api.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse cadastraNovoUsuario(UsuarioRequest usuarioRequest);
}
