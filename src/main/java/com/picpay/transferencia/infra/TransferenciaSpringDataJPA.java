package com.picpay.transferencia.infra;

import com.picpay.transferencia.dominio.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaSpringDataJPA extends JpaRepository<Transferencia,UUID> {
}
