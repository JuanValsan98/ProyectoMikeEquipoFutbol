package com.entrenamiento.demo.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrenamiento.demo.dto.jugadorRequestDTO;
import com.entrenamiento.demo.dto.jugadorResponseDTO;
import com.entrenamiento.demo.service.jugadorService;
import lombok.AllArgsConstructor;


@RestController 
@AllArgsConstructor 
@RequestMapping("/jugadorController")
public class jugadorController {
    public final jugadorService jugadorService;
    @PostMapping("/createjugador")
   public ResponseEntity<jugadorResponseDTO> createJugador (@RequestBody jugadorRequestDTO request){
    jugadorResponseDTO response = jugadorService.createJugador(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
    
}
@GetMapping("/listarJugador")
   public ResponseEntity<List<jugadorResponseDTO>> listarJugador(){
      List<jugadorResponseDTO> response = jugadorService.getAllJugador();
      return ResponseEntity.status(HttpStatus.OK).body(response);
   }
}
