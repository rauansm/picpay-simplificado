package com.picpay.usuario.infra;

import com.picpay.usuario.dominio.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPA usuarioSpringDataJPA;
    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioInfraRepository - salva");
        usuarioSpringDataJPA.save(usuario);
        log.info("[finaliza] UsuarioInfraRepository - salva");
        return usuario;
    }
}
