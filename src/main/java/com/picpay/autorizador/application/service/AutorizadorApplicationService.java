package com.picpay.autorizador.application.service;

import com.picpay.transferencia.dominio.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutorizadorApplicationService implements AutorizadorService {
    @Override
    public void autorizaTransferencia(Transferencia transferencia) {

    }
}
