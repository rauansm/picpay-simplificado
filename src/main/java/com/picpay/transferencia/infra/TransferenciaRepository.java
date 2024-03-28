package com.picpay.transferencia.infra;

import com.picpay.transferencia.dominio.Transferencia;

import java.util.List;

public interface TransferenciaRepository {
    Transferencia salva(Transferencia transferencia);

    List<Transferencia> listaTodasTransferencias();
}
