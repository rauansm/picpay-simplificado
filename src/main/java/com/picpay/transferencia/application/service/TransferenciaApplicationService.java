package com.picpay.transferencia.application.service;

import com.picpay.autorizador.application.service.AutorizadorService;
import com.picpay.notificacao.publicador.PublicadorNotificacao;
import com.picpay.transferencia.application.api.TransferenciaDetalhadaResponse;
import com.picpay.transferencia.application.api.TransferenciaRequest;
import com.picpay.transferencia.application.api.TransferenciaResponse;
import com.picpay.transferencia.dominio.Transferencia;
import com.picpay.transferencia.infra.TransferenciaRepository;
import com.picpay.usuario.dominio.Usuario;
import com.picpay.usuario.infra.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransferenciaApplicationService implements TransferenciaService {
    private final TransferenciaRepository transferenciaRepository;
    private final UsuarioRepository usuarioRepository;
    private final AutorizadorService autorizadorService;
    private final PublicadorNotificacao publicadorNotificacao;
    @Transactional
    @Override
    public TransferenciaResponse realizaTransferencia(TransferenciaRequest transferenciaRequest) {
        log.info("[inicia] TransferenciaApplicationService - realizaTransferencia");
        Usuario pagador = usuarioRepository.buscaUsuarioPorId(transferenciaRequest.getPagador());
        Usuario beneficiario = usuarioRepository.buscaUsuarioPorId(transferenciaRequest.getBeneficiario());

        Transferencia transferencia = new Transferencia(transferenciaRequest);
        transferencia.realizaTransferencia(pagador,beneficiario,autorizadorService);

        transferenciaRepository.salva(transferencia);
        usuarioRepository.salva(pagador);
        usuarioRepository.salva(beneficiario);

        publicadorNotificacao.notifica(transferencia,beneficiario);
        log.info("[finaliza] TransferenciaApplicationService - realizaTransferencia");
        return new TransferenciaResponse(transferencia);
    }

    @Override
    public List<TransferenciaDetalhadaResponse> listaTodasTransferencias() {
        log.info("[inicia] TransferenciaApplicationService - listaTodasTransferencias");
        List<Transferencia> transferencias = transferenciaRepository.listaTodasTransferencias();
        log.info("[finaliza] TransferenciaApplicationService - listaTodasTransferencias");
        return null;
    }
}
