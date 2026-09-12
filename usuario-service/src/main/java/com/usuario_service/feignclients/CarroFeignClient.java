package com.usuario_service.feignclients;

import com.usuario_service.models.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service")//, url= "http://localhost:8002")
@RequestMapping("/api2/v1")
public interface CarroFeignClient {

    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
