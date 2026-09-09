package com.car_service.controller;

import com.car_service.entity.Carro;
import com.car_service.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2/v1")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> listarCarros(){
        List<Carro> carros = carroService.getAll();
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/carro/{id}")
    public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
        Carro carro = carroService.getCarroById(id);
        if (carro == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carro);
    }

    @PostMapping("/carro")
    public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
        Carro nuevoCarro = carroService.save(carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
        List<Carro> carros = carroService.byUsuario(usuarioId);
        if (carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

}
