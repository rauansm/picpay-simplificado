package com.picpay.autorizador.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "autorizadorClientFeing", url = "${autorizador.api.server}")
public interface AutorizadorClientFeign {
    @GetMapping
  ResponseEntity<AutorizadorResponse> autorizaTransferencia();
}
