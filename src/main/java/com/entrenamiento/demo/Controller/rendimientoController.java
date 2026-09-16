package com.entrenamiento.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entrenamiento.demo.dto.rendimientojugadorRequestDTO;
import com.entrenamiento.demo.dto.rendimientojugadorResponseDTO;
import com.entrenamiento.demo.dto.jugadorTitularResponseDTO;
import com.entrenamiento.demo.service.rendimientoService;

import lombok.AllArgsConstructor;
import java.util.List;


@RestController 
@AllArgsConstructor 
@RequestMapping("/rendimientoService")
public class rendimientoController {
    public final rendimientoService rendimientoService;
    @PostMapping("/crearRendimiento")
    public ResponseEntity<rendimientojugadorResponseDTO> crearRendimiento (@RequestBody rendimientojugadorRequestDTO request ){
        rendimientojugadorResponseDTO response = rendimientoService.crearRendimiento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
    @GetMapping("/listarTitulares")
    public ResponseEntity<List<jugadorTitularResponseDTO>> listarTitulares() {
        List<jugadorTitularResponseDTO> response = rendimientoService.listarTitulares();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

    
}
