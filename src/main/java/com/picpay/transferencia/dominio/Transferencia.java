package com.picpay.transferencia.dominio;

import com.picpay.autorizador.application.service.AutorizadorService;
import com.picpay.handler.APIException;
import com.picpay.transferencia.application.api.TransferenciaRequest;
import com.picpay.usuario.dominio.TipoUsuario;
import com.picpay.usuario.dominio.Usuario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private BigDecimal valor;
    private UUID pagador;
    private UUID beneficiario;
    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    public Transferencia(TransferenciaRequest transferenciaRequest) {
        this.valor = transferenciaRequest.getValor();
        this.pagador = transferenciaRequest.getPagador();
        this.beneficiario = transferenciaRequest.getBeneficiario();
    }

    public void realizaTransferencia(Usuario pagador, Usuario beneficiario, AutorizadorService autorizadorService) {
        validaTransferencia(pagador);
        autorizaTransferencia(autorizadorService);
        pagador.debitar(this.valor);
        beneficiario.creditar(this.valor);
    }

    private void autorizaTransferencia(AutorizadorService autorizadorService) {
        autorizadorService.autorizaTransferencia(this);
    }

    private void validaTransferencia(Usuario pagador) {
        if (pagador.getTipoUsuario().equals(TipoUsuario.LOJISTA) || pagador.getId().equals(this.beneficiario)){
            throw APIException.negocio("Você não possui autorização para realizar essa operação");
        }
       verificaSaldoDisponivel(pagador);
    }

    private void verificaSaldoDisponivel(Usuario pagador) {
        if (pagador.getCarteira().compareTo(this.valor) < 0) {
            throw APIException.saldoInsuficiente("Saldo insuficiente para realizar a transferência.");
        }
    }
}
