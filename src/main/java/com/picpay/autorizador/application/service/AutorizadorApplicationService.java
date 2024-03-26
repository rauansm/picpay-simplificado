package com.picpay.autorizador.application.service;

import com.picpay.autorizador.infra.client.AutorizadorResponse;
import com.picpay.autorizador.infra.client.SerproClientFeign;
import com.picpay.handler.APIException;
import com.picpay.transferencia.dominio.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutorizadorApplicationService implements AutorizadorService {
    private final SerproClientFeign serproClientFeign;
    @Override
    public void autorizaTransferencia(Transferencia transferencia) {
        log.debug("[inicia] AutorizadorApplicationService - autorizaTransferencia");
        try {
            ResponseEntity<AutorizadorResponse> autorizador = serproClientFeign.autorizaTransferencia();
            autorizar(autorizador);
        }catch (Exception e){
            throw APIException.tranferenciaNaoAutorizada("Serviço indisponivel");
        }
        log.debug("[finaliza] AutorizadorApplicationService - autorizaTransferencia");
    }

    private void autorizar(ResponseEntity<AutorizadorResponse> autorizador) {
        if (autorizador.getStatusCode().isError() || autorizador.getBody().isInvalid()) {
            throw APIException.tranferenciaNaoAutorizada("Transferência não autorizada.");
        }
    }
}
