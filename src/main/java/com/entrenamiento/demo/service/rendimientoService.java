package com.entrenamiento.demo.service;

import com.entrenamiento.demo.dto.jugadorPromedio;
import com.entrenamiento.demo.dto.jugadorTitularResponseDTO;
import com.entrenamiento.demo.dto.rendimientojugadorRequestDTO;
import com.entrenamiento.demo.dto.rendimientojugadorResponseDTO;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.entrenamiento.demo.Entity.jugador;
import com.entrenamiento.demo.Entity.rendimientojugador;
import com.entrenamiento.demo.repository.rendimientoRepository;
import com.entrenamiento.demo.repository.jugadorRepository;

import lombok.AllArgsConstructor;


@Service 
@AllArgsConstructor 
public class rendimientoService {
    private final jugadorRepository jugadorRepository;
    private final rendimientoRepository rendimientoRepository;

    public rendimientojugadorResponseDTO crearRendimiento(rendimientojugadorRequestDTO request){
          Optional<jugador> jugadorEncontrado = jugadorRepository.findById(request.getJugadorId());

if (jugadorEncontrado.isEmpty()) {
    throw new RuntimeException("Ese jugador con esa id no existe");
}

jugador Jugador = jugadorEncontrado.get();

double resultado = (request.getPotenciaDeTiro() * 0.20)
                 + (request.getVelocidad() * 0.30)
                 + (request.getPases() * 0.50);

    rendimientojugador rendimientojugador = new rendimientojugador();
    rendimientojugador.setPotenciaDeTiro(request.getPotenciaDeTiro());
    rendimientojugador.setVelocidad(request.getVelocidad());
    rendimientojugador.setPases(request.getPases());
    rendimientojugador.setResultado(resultado);

    rendimientojugador.setJugador(Jugador);
    rendimientoRepository.save(rendimientojugador);

    rendimientojugadorResponseDTO response = new rendimientojugadorResponseDTO();
    response.setJugadorId(rendimientojugador.getId());
    response.setPotenciaDeTiro(rendimientojugador.getPotenciaDeTiro());
    response.setVelocidad(rendimientojugador.getVelocidad());
    response.setPases(rendimientojugador.getPases());
    response.setResultado(resultado);
    return response;

    }

    public List<jugadorTitularResponseDTO> listarTitulares() {
        List<rendimientojugador> todos = rendimientoRepository.findAll();

        Map<jugador, List<rendimientojugador>> agrupadoPorJugador = new HashMap<>();
        for (rendimientojugador rendimientoJugador : todos) {
            jugador jugador = rendimientoJugador.getJugador();
            if (!agrupadoPorJugador.containsKey(jugador)) {
                agrupadoPorJugador.put(jugador, new ArrayList());
            
            }
            agrupadoPorJugador.get(jugador).add(rendimientoJugador);
        }

    List<jugadorPromedio> elegibles = new ArrayList<>();
    for (Map.Entry<jugador, List<rendimientojugador>> entrada : agrupadoPorJugador.entrySet()) {
        jugador jugador = entrada.getKey();
        List<rendimientojugador> LosRendimientojugadores = entrada.getValue();
        
        if (susRendimientos.Size() == 3) {
            double suma = 0;
            for (rendimientojugador rendimientoJugador : LosRendimientojugadores) {
                suma = suma + rendimientoJugador.getResultado();
            }
            double promedio = suma / 3;
            elegibles.add(new jugadorPromedio(jugador, promedio));
        }
    }

    elegibles.sort(Comparator.comparing(jugadorPromedio::getPromedio).reversed());
    List<jugadorPromedio> titulares = elegibles.subList(0, Math.min(5, elegibles.size()));

    List<jugadorTitularResponseDTO> response = new ArrayList<>();
    for (jugadorPromedio jugadorPromedio : titulares) {
        jugadorTitularResponseDTO titularDTO = new jugadorTitularResponseDTO();
        titularDTO.setJugadorName(jugadorPromedio.getJugador().getName());
        titularDTO.setPromedio(jugadorPromedio.getPromedio());
        response.add(titularDTO);
    }

    return response;

    }


}
