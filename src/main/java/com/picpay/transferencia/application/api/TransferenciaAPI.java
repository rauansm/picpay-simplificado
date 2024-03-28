package com.picpay.transferencia.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransferenciaResponse realizaTransferencia (@RequestBody @Valid TransferenciaRequest transferenciaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<TransferenciaDetalhadaResponse> listaTodasTransferencias ();
}
