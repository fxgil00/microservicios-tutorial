package com.usuario_service.feignclients;

import com.usuario_service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moto-service")//, url = "http://localhost:8003"
@RequestMapping("/api3/v1")
public interface MotoFeignClient {

    @PostMapping("/moto")
    public Moto save(@RequestBody Moto moto);

    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);

}
