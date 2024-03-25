package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.TipoUsuario;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UsuarioRequest {
    private String nomeCompleto;
    private String email;
    private String cpfCnpj;
    private String senha;
    private TipoUsuario tipoUsuario;
}
