package com.picpay.transferencia.application.api;

import com.picpay.transferencia.dominio.Transferencia;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class TransferenciaDetalhadaResponse {

     UUID id;
     BigDecimal valor;
     UUID pagador;
     UUID beneficiario;
     LocalDateTime dataCriacao;

    public TransferenciaDetalhadaResponse(Transferencia transferencia) {
        this.id = transferencia.getId();
        this.valor = transferencia.getValor();
        this.pagador = transferencia.getPagador();
        this.beneficiario = transferencia.getBeneficiario();
        this.dataCriacao = transferencia.getDataCriacao();
    }

    public static List<TransferenciaDetalhadaResponse> converte(List<Transferencia> transferencias) {
        return transferencias.stream()
                .map(TransferenciaDetalhadaResponse::new)
                .collect(Collectors.toList());
    }
}
