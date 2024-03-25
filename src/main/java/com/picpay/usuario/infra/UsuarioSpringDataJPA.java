package com.picpay.usuario.infra;

import com.picpay.usuario.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioSpringDataJPA extends JpaRepository<Usuario, UUID> {
}
