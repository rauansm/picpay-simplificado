package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.TipoUsuario;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Value
public class UsuarioRequest {
    @NotBlank(message = "Nome é obrigatório")
    String nomeCompleto;
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email;
    @NotBlank(message = "CPF/CNPJ é obrigatório")
    String cpfCnpj;
    @NotBlank(message = "Senha é obrigatório")
    @Size(min = 6)
    String senha;
    @NotNull(message = "Tipo Usuario é obrigatório")
    TipoUsuario tipoUsuario;
}
