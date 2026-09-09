package com.moto_service.controller;

import com.moto_service.entity.Moto;
import com.moto_service.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api3/v1")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping("/motos")
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/moto/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
        Moto moto = motoService.getMotoById(id);
        if (moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }

    @PostMapping("/moto")
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto nuevaMoto = motoService.save(moto);
        return ResponseEntity.ok(nuevaMoto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int usuarioId){
        List<Moto> motos = motoService.byUsuario(usuarioId);
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

}
