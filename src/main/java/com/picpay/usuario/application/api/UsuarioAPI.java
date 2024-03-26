package com.picpay.usuario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioResponse cadastraNovoUsuario (@RequestBody @Valid UsuarioRequest usuarioRequest);

    @GetMapping("/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioDetalhadoResponse buscaUsuarioPorId(@PathVariable UUID idUsuario);
}
