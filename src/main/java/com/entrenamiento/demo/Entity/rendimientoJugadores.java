package com.entrenamiento.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity 
@Data 
public class rendimientoJugadores {
    @Column (name="Potencia de tiro")
    private double potenciaDeTiro;

    @Column (name="Velocidad en Km/h")
    private double velocidad;

    @Column (name="Pases")
    private double pases;

    @Column (name="resultado")
    private double resultado;

}