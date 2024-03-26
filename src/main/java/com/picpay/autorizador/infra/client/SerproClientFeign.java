package com.picpay.autorizador.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "serproClientFeing", url = "https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
public interface SerproClientFeign {
    @GetMapping
  ResponseEntity<AutorizadorResponse> autorizaTransferencia();
}
