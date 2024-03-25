package com.picpay.usuario.dominio;

import com.picpay.core.beanvalidation.CnpjGroup;
import com.picpay.core.beanvalidation.CpfGroup;
import com.picpay.core.beanvalidation.UsuarioGroupSequenceProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@GroupSequenceProvider(UsuarioGroupSequenceProvider.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String nomeCompleto;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;
    private String senha;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
    private BigDecimal carteira;
}
