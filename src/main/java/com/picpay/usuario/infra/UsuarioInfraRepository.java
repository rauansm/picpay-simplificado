package com.picpay.usuario.infra;

import com.picpay.handler.APIException;
import com.picpay.usuario.dominio.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPA usuarioSpringDataJPA;
    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UsuarioInfraRepository - salva");
        try {
            usuarioSpringDataJPA.save(usuario);
        } catch (DataIntegrityViolationException e){
            throw APIException.dadosDuplicados("Usuário já cadastrado.");
        }
        log.info("[finaliza] UsuarioInfraRepository - salva");
        return usuario;
    }

    @Override
    public Usuario buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioInfraRepository - buscaUsuarioPorId");
        Optional<Usuario> usuario = usuarioSpringDataJPA.findById(idUsuario);
        log.info("[finaliza] UsuarioInfraRepository - buscaUsuarioPorId");
        return usuario.orElseThrow(() -> APIException.entidadeNaoEncontrada(
                String.format("Usuário de id %s não encontrado.", idUsuario)));
    }
}
