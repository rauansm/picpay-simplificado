package com.picpay.notificacao.publicador;

import com.picpay.transferencia.dominio.Transferencia;
import com.picpay.usuario.dominio.Usuario;
import lombok.Getter;
import org.springframework.amqp.core.MessagePostProcessor;

import java.math.BigDecimal;

@Getter
public class TransferenciaDTO {
    private final Transferencia transferencia;
    private final Usuario beneficiario;
    public TransferenciaDTO(Transferencia transferencia, Usuario beneficiario) {
        this.transferencia = transferencia;
        this.beneficiario = beneficiario;
    }
}
