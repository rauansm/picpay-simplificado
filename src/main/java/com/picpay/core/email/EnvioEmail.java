package com.picpay.core.email;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

import java.util.Map;

public interface EnvioEmail {
    void enviar(Mensagem mensagem);


    @Getter
    @Builder
    class Mensagem {

        private String destinatario;
        @NonNull
        private String assunto;
        @NonNull
        private String corpo;
        @Singular("variavel")
        private Map<String, Object> variaveis;
    }
}
