package com.picpay.transferencia.application.service;

import com.picpay.transferencia.application.api.TransferenciaRequest;
import com.picpay.transferencia.application.api.TransferenciaResponse;

public interface TransferenciaService {
    TransferenciaResponse realizaTransferencia(TransferenciaRequest transferenciaRequest);
}
