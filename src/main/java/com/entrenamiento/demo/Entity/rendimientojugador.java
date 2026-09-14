package com.entrenamiento.demo.Entity;

import com.entrenamiento.demo.Entity.jugador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity 
@Data 
public class rendimientojugador {
    @id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column (name="Potencia de tiro")
    private double potenciaDeTiro;

    @Column (name="Velocidad en Km/h")
    private double velocidad;

    @Column (name="Pases")
    private Long pases;

    @ManyToOne 
    @JoinColumn(name ="jugador_id")
    private jugador jugador;

}