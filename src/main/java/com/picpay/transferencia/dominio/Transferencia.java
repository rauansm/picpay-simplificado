package com.picpay.transferencia.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private BigDecimal valor;
    private UUID pagador;
    private UUID beneficiario;
    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @Version
    private Long version;
}
