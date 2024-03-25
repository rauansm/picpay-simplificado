package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;


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
    String senha;
    @NotNull(message = "Tipo Usuario é obrigatório")
    TipoUsuario tipoUsuario;
}
