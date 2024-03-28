package com.picpay.core.email;

import com.picpay.handler.APIException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
public class SmtpEnvioEmail implements EnvioEmail {

    private final JavaMailSender mailSender;
    private final EmailProperties emailProperties;
    private final Configuration freemakerConfig;

    @Override
    public void enviar(Mensagem mensagem) {
        log.info("[inicia] SmtpEnvioEmail - enviar");
        try {
            String corpo = processarTemplate(mensagem);

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setSubject(mensagem.getAssunto());
            helper.setFrom(emailProperties.getRemetente());
            helper.setText(corpo, true);
            helper.setTo(mensagem.getDestinatario());
            mailSender.send(mimeMessage);

            log.info("[finaliza] SmtpEnvioEmail - enviar");
        } catch (Exception e) {
            throw APIException.servicoIndisponivel("Error ao enviar email" , e);
        }
    }

    private String processarTemplate(Mensagem mensagem) throws IOException, TemplateException {
        log.info("[inicia] SmtpEnvioEmail - processarTemplate");
        Template template = freemakerConfig.getTemplate(mensagem.getCorpo());
        log.info("[finaliza] SmtpEnvioEmail - processarTemplate");
        return FreeMarkerTemplateUtils.processTemplateIntoString(
                template,mensagem.getVariaveis());
    }

}
