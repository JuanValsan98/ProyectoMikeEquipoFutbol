package com.entrenamiento.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entrenamiento.demo.dto.jugadorRequestDTO;
import com.entrenamiento.demo.dto.jugadorResponseDTO;
import com.entrenamiento.demo.Entity.jugador;
import com.entrenamiento.demo.repository.jugadorRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
@Service 
@AllArgsConstructor 
@Data 


public class jugadorService {
    private final jugadorRepository jugadorRepository;  

    public jugadorResponseDTO createJugador (jugadorRequestDTO request) {
        
       
       
        jugador jugador = new jugador();
        jugador.setName(request.getName());
        jugadorRepository.save(jugador);

        jugadorResponseDTO response = new jugadorResponseDTO();
        response.setId(jugador.getId());
        response.setName(jugador.getName());
        return response;
    }

    public List<jugadorResponseDTO>  getAllJugador () {
        List<jugadorResponseDTO> response = new ArrayList<>();
        List<jugador> usersFound = jugadorRepository.findAll();

        for (jugador jugadorFound : usersFound) {
            jugadorResponseDTO jugador = new jugadorResponseDTO();
            jugador.setId(jugadorFound.getId());
            jugador.setName(jugadorFound.getName());

            response.add(jugador);
        }
        return response;


    }
    




}

   

