package com.picpay.transferencia.application.service;

import com.picpay.transferencia.application.api.TransferenciaDetalhadaResponse;
import com.picpay.transferencia.application.api.TransferenciaRequest;
import com.picpay.transferencia.application.api.TransferenciaResponse;

import java.util.List;

public interface TransferenciaService {
    TransferenciaResponse realizaTransferencia(TransferenciaRequest transferenciaRequest);

    List<TransferenciaDetalhadaResponse> listaTodasTransferencias();
}
