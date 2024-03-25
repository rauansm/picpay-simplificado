package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.Usuario;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioResponse {
    UUID id;
    public UsuarioResponse(Usuario novoUsuario) {
        this.id = novoUsuario.getId();
    }
}
