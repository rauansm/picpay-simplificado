package com.picpay.autorizador.application.service;

import com.picpay.transferencia.dominio.Transferencia;

public interface AutorizadorService {
    void autorizaTransferencia(Transferencia transferencia);
}
