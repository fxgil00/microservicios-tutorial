package com.usuario_service.controlador;

import com.usuario_service.entidades.Usuario;
import com.usuario_service.models.Carro;
import com.usuario_service.models.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.usuario_service.servicio.UsuarioService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api1/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.getAll();
        if (usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> getCarros(@PathVariable("usuarioId") int usuarioId){
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
        if ((usuario == null)){
            return  ResponseEntity.notFound().build();
        }
        List<Carro> carros = usuarioService.getCarros(usuarioId);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("usuarioId") int usuarioId){
        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
        if ((usuario == null)){
            return  ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioService.getMotos(usuarioId);
        return ResponseEntity.ok(motos);
    }

    @PostMapping("/carro/{usuarioId}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int usuarioId,
                                              @RequestBody Carro carro){
        Carro nuevoCarro = usuarioService.saveCarro(usuarioId, carro);
        return ResponseEntity.ok(nuevoCarro);
    }

    @PostMapping("/moto/{usuarioId}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("usuarioId") int usuarioId,
                                              @RequestBody Moto moto){
        Moto nuevoMoto = usuarioService.saveMoto(usuarioId, moto);
        return ResponseEntity.ok(nuevoMoto);
    }

    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String, Object>> listaTodos(@PathVariable("usuarioId") int usuarioId){
        Map<String, Object> resultado = usuarioService.getUsuarioAndVehiculos(usuarioId);
        return ResponseEntity.ok(resultado);
    }

}
