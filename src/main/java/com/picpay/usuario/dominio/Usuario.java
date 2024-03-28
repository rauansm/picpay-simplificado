package com.picpay.usuario.dominio;

import com.picpay.core.beanvalidation.CnpjGroup;
import com.picpay.core.beanvalidation.CpfGroup;
import com.picpay.core.beanvalidation.UsuarioGroupSequenceProvider;
import com.picpay.usuario.application.api.UsuarioRequest;
import lombok.*;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@GroupSequenceProvider(UsuarioGroupSequenceProvider.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(name = "cpf_cnpj", unique = true)
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;
    private String senha;
    @CreationTimestamp
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;
    private BigDecimal carteira;
    @Version
    private Long version;

    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNomeCompleto();
        this.email = usuarioRequest.getEmail();
        this.cpfCnpj = usuarioRequest.getCpfCnpj();
        this.senha = usuarioRequest.getSenha();
        this.tipoUsuario = usuarioRequest.getTipoUsuario();
        this.carteira = BigDecimal.ZERO;

    }

    public void debitar(BigDecimal valor) {
     this.carteira = this.carteira.subtract(valor);
    }

    public void creditar(BigDecimal valor) {
      this.carteira = this.carteira.add(valor);
    }
}
