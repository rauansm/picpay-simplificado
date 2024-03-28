package com.picpay.autorizador.application.service;

import com.picpay.autorizador.infra.client.AutorizadorResponse;
import com.picpay.autorizador.infra.client.autorizadorClientFeign;
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
    private final autorizadorClientFeign autorizadorClientFeign;
    @Override
    public void autorizaTransferencia(Transferencia transferencia) {
        log.debug("[inicia] AutorizadorApplicationService - autorizaTransferencia");
           try {
               ResponseEntity<AutorizadorResponse> autorizador = autorizadorClientFeign.autorizaTransferencia();
               autorizar(autorizador);
           }catch (Exception ex){
               throw APIException.servicoIndisponivel("O sistema autorizador está temporariamente indisponível.",ex);
           }
        log.debug("[finaliza] AutorizadorApplicationService - autorizaTransferencia");
    }

    private void autorizar(ResponseEntity<AutorizadorResponse> autorizador) {
        if (autorizador.getStatusCode().isError() || autorizador.getBody().isInvalid()) {
            throw APIException.tranferenciaNaoAutorizada("Transferência não autorizada.");
        }
    }
}
