package com.picpay.transferencia.infra;

import com.picpay.transferencia.dominio.Transferencia;

public interface TransferenciaRepository {
    Transferencia salva(Transferencia transferencia);
}
