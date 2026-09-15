package com.entrenamiento.demo.service;

import org.springframework.stereotype.Service;

import com.entrenamiento.demo.dto.jugadorRequestDTO;
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

public class jugadorService {
    private final jugadorRepository JugadorRepository;  

    public jugadorResponseDTO createJugador (jugadorRequestDTO request) {
        
       
        public JugadorResponseDTO crearJugador(jugadorRequestDTO request) {
        jugador Jugador = new Jugador();
        jugador.setname(request.getname());
        jugadorRepository.save(jugador);

        jugadorResponseDTO response = new JugadorResponseDTO();
        response.setid(jugador.getid());
        response.setname(jugador.getname());
        return response;
    }
    
}

}
