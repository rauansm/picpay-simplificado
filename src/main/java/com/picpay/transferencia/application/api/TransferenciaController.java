package com.picpay.transferencia.application.api;

import com.picpay.transferencia.application.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public List<TransferenciaDetalhadaResponse> listaTodasTransferencias() {
        log.info("[inicia] TransferenciaController - listaTodasTransferencias");
        List<TransferenciaDetalhadaResponse> transferencias = transferenciaService.listaTodasTransferencias();
        log.info("[finaliza] TransferenciaController - listaTodasTransferencias");
        return transferencias;
    }
}
