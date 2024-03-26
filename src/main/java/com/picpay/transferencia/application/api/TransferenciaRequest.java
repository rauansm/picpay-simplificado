package com.picpay.transferencia.application.api;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Value
public class TransferenciaRequest {
    @NotNull(message = "Valor é obrigatório")
    BigDecimal valor;
    @NotNull(message = "Pagador é obrigatório")
    UUID pagador;
    @NotNull(message = "Beneficiário é obrigatório")
    UUID beneficiario;
}
