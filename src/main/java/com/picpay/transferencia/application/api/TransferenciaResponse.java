package com.picpay.transferencia.application.api;

import com.picpay.transferencia.dominio.Transferencia;
import lombok.Value;

import java.util.UUID;

@Value
public class TransferenciaResponse {
    UUID id;

    public TransferenciaResponse(Transferencia transferencia) {
        this.id = transferencia.getId();
    }
}
