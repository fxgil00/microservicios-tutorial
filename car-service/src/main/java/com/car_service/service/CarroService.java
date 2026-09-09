package com.car_service.service;

import com.car_service.entity.Carro;
import com.car_service.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAll(){
        return carroRepository.findAll();
    }

    public Carro getCarroById(int id){
        return carroRepository.findById(id).orElse(null);
    }

    public Carro save(Carro Carro){
        Carro nuevoCarro = carroRepository.save(Carro);
        return nuevoCarro;
    }

    public List<Carro> byUsuario(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }
}
