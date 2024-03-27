package com.picpay.notificacao.publicador;

import com.picpay.transferencia.dominio.Transferencia;
import com.picpay.usuario.dominio.Usuario;

public interface PublicadorNotificacao {
    void notifica(Transferencia transferencia, Usuario beneficiario);
}
