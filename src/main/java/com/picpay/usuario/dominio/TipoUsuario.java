package com.picpay.usuario.dominio;

import com.picpay.core.beanvalidation.CnpjGroup;
import com.picpay.core.beanvalidation.CpfGroup;
import lombok.Getter;

@Getter
public enum TipoUsuario {
    COMUM("Comum", "CPF", "000.000.000-00", CpfGroup.class),
    LOJISTA("Lojista", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private final Class<?> group;

    TipoUsuario(String descricao, String documento, String mascara, Class<?> group) {
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }
}
