package com.entrenamiento.demo.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrenamiento.demo.dto.jugadorRequestDTO;
import com.entrenamiento.demo.dto.jugadorResponseDTO;
import com.entrenamiento.demo.dto.rendimientojugadorRequestDTO;
import com.entrenamiento.demo.service.jugadorService;
import lombok.AllArgsConstructor;


@RestController 
@AllArgsConstructor 
@RequestMapping("/jugadorController")
public class jugadorController {
    public final jugadorService JugadorService;
    @PostMapping("/createjugador")
   public ResponseEntity<jugadorResponseDTO> createJugador (@RequestBody jugadorRequestDTO request){
    jugadorResponseDTO response = JugadorService.createJugador(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    
}
}
