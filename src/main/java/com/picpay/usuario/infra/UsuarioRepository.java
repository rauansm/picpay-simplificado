package com.picpay.usuario.infra;

import com.picpay.usuario.dominio.Usuario;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);
}
