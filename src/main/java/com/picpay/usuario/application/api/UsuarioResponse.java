package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.Usuario;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
public class UsuarioResponse {
    private UUID id;
    public UsuarioResponse(Usuario novoUsuario) {
        this.id = novoUsuario.getId();
    }
}
