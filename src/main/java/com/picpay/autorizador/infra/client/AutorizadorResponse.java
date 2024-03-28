package com.picpay.autorizador.infra.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AutorizadorResponse {

    @JsonProperty("message")
    private String message;

    public boolean isInvalid() {
        return !isValid();
    }
    private boolean isValid() {
        return this.message.equals("Autorizado");
    }
}
