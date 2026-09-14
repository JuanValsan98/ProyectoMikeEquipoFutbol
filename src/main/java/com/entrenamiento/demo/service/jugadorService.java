package com.entrenamiento.demo.service;

import org.springframework.stereotype.Service;

import com.entrenamiento.demo.dto.jugadorResponseDTO;
import com.entrenamiento.demo.dto.jugadorResponseDTO;
import com.entrenamiento.demo.dto.rendimientojugadorRequestDTO;
import com.entrenamiento.demo.dto.rendimientojugadorResponseDTO;
import com.entrenamiento.demo.Entity.jugador;
import com.entrenamiento.demo.repository.jugadorRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
@Service 
@AllArgsConstructor 
@Data 

public class servicejugador {
    private final jugadorRepository JugadorRepository;  
    
}
