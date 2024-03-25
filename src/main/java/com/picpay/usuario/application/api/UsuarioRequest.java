package com.picpay.usuario.application.api;

import com.picpay.usuario.dominio.TipoUsuario;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
public class UsuarioRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nomeCompleto;
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank(message = "CPF/CNPJ é obrigatório")
    private String cpfCnpj;
    @NotBlank(message = "Senha é obrigatório")
    private String senha;
    @NotNull(message = "Tipo Usuario é obrigatório")
    private TipoUsuario tipoUsuario;
}
