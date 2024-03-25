package com.picpay.transferencia.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/transferencia")
public interface TransferenciaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TransferenciaResponse realizaTransferencia (@RequestBody @Valid TransferenciaRequest transferenciaRequest);
}
