package com.picpay.notificacao.publicador;

import com.picpay.transferencia.dominio.Transferencia;
import com.picpay.usuario.dominio.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorNotificacaoRabbitMQ implements PublicadorNotificacao {
    private final RabbitTemplate rabbitTemplate;
    @Override
    public void notifica(Transferencia transferencia, Usuario beneficiario) {
        log.info("[inicia] NotificadorTransferenciaInfraRabbit - notifica");
        rabbitTemplate.convertAndSend("transferencia.ex","notifica.email",new TransferenciaDTO(transferencia,beneficiario));
        log.info("[finaliza] NotificadorTransferenciaInfraRabbit - notifica");
    }
}
