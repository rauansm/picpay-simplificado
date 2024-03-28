package com.picpay.transferencia.infra;

import com.picpay.transferencia.dominio.Transferencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TransferenciaInfraRepository implements TransferenciaRepository {
    private final TransferenciaSpringDataJPA transferenciaSpringDataJPA;
    @Override
    public Transferencia salva(Transferencia transferencia) {
        log.info("[inicia] TransferenciaInfraRepository - salva");
        transferenciaSpringDataJPA.save(transferencia);
        log.info("[finaliza] TransferenciaInfraRepository - salva");
        return transferencia;
    }

    @Override
    public List<Transferencia> listaTodasTransferencias() {
        log.info("[inicia] TransferenciaInfraRepository - listaTodasTransferencias");
        List<Transferencia> transferencias = transferenciaSpringDataJPA.findAll();
        log.info("[finaliza] TransferenciaInfraRepository - listaTodasTransferencias");
        return transferencias;
    }
}
