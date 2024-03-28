package com.picpay.transferencia.application.api;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Value
public class TransferenciaRequest {
    @NotNull(message = "Valor é obrigatório")
    @Positive
    BigDecimal valor;
    @NotNull(message = "Pagador é obrigatório")
    UUID pagador;
    @NotNull(message = "Beneficiário é obrigatório")
    UUID beneficiario;
}
