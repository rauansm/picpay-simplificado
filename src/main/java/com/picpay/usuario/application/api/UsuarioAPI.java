package com.picpay.usuario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioResponse cadastraNovoUsuario (@RequestBody @Valid UsuarioRequest usuarioRequest);
}
