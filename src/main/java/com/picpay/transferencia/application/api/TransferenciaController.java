package com.picpay.transferencia.application.api;

import com.picpay.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class TransferenciaController implements TransferenciaAPI {
    private final TransferenciaService transferenciaService;
    @Override
    public TransferenciaResponse realizaTransferencia(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia] TransferenciaController - realizaTransferencia");
        TransferenciaResponse transferencia = transferenciaService.realizaTransferencia(transferenciaRequest);
        log.info("[finaliza] TransferenciaController - realizaTransferencia");
        return transferencia;
    }
}
