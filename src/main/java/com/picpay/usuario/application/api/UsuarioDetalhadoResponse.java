package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.TipoUsuario;
import com.picpay.usuario.dominio.Usuario;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class UsuarioDetalhadoResponse {
    UUID id;
    String nome;
    String email;
    String cpfCnpj;
    TipoUsuario tipoUsuario;
    BigDecimal carteira;

    public UsuarioDetalhadoResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpfCnpj = usuario.getCpfCnpj();
        this.tipoUsuario = usuario.getTipoUsuario();
        this.carteira = usuario.getCarteira();
    }
}
