package com.picpay.handler;

import lombok.Getter;

@Getter
public enum ProblemType {
    REGISTRO_DUPLICADO("/dados-duplicado", "Dados duplicados"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    SALDO_INSUFICIENTE("/saldo-insuficiente", "Saldo insuficiente"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "https://picpay.com" + path;
        this.title = title;
    }

}
