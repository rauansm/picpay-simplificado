package com.picpay.usuario.infra;

import com.picpay.usuario.dominio.Usuario;

import java.util.UUID;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);

    Usuario buscaUsuarioPorId(UUID idUsuario);
}
