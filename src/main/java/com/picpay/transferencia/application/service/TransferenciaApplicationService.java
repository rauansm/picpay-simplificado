package com.picpay.transferencia.application.service;

import com.picpay.transferencia.application.api.TransferenciaRequest;
import com.picpay.transferencia.application.api.TransferenciaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransferenciaApplicationService implements TransferenciaService {
    @Override
    public TransferenciaResponse realizaTransferencia(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia] TransferenciaApplicationService - realizaTransferencia");

        log.info("[finaliza] TransferenciaApplicationService - realizaTransferencia");
        return null;
    }
}
