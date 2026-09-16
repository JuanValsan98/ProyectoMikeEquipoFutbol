package com.entrenamiento.demo.dto;

import com.entrenamiento.demo.Entity.jugador;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class jugadorPromedio {
    
    //Para aclarar todo, esto es una clase auxiliar en el cuál se guardan cositas temporales, esto
    //para que digamos al momento de hacer la lista de los jugadores con los promedios no se pierdan o
    //no se queden registrados como una funcion si no un objeto

    private jugador jugador;
    private double promedio;

}