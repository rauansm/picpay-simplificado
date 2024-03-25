package com.picpay.core.beanvalidation;

import com.picpay.usuario.dominio.Usuario;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class UsuarioGroupSequenceProvider implements DefaultGroupSequenceProvider<Usuario> {
    @Override
    public List<Class<?>> getValidationGroups(Usuario usuario) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Usuario.class);
        if (isPessoaSelecionada(usuario)){
            groups.add(usuario.getTipoUsuario().getGroup());
        }
        return groups;
    }

    private boolean isPessoaSelecionada(Usuario usuario) {
        return usuario != null && usuario.getTipoUsuario() != null;
    }
}

