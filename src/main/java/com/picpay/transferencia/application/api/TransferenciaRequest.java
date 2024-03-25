package com.picpay.transferencia.application.api;

import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class TransferenciaRequest {
    BigDecimal valor;
    UUID pagador;
    UUID beneficiario;
}
