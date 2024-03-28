package com.picpay.notificacao.consumidor;

import com.picpay.core.email.EnvioEmail;
import com.picpay.notificacao.publicador.TransferenciaDTO;
import com.picpay.transferencia.dominio.Transferencia;
import com.picpay.usuario.dominio.Usuario;
import com.picpay.usuario.infra.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class NotificacaoTransferenciaRealizadaListener {
    private final EnvioEmail envioEmail;
    @RabbitListener(queues = "notifica.email")
    public void aoConfirmarTransferencia(TransferenciaDTO transferencia) {
        log.info("[inicia] NotificacaoTransferenciaRealizadaListener - notifica");
        var mensagem = EnvioEmail.Mensagem.builder()
                .assunto(transferencia.getBeneficiario().getNome() + " - Transferencia Recebida")
                .corpo("transferencia-aprovada.html")
                .variavel("transferencia", transferencia)
                .destinatario(transferencia.getBeneficiario().getEmail())
                .build();
        envioEmail.enviar(mensagem);
        log.info("[finaliza] NotificacaoTransferenciaRealizadaListener - notifica");
    }
}
