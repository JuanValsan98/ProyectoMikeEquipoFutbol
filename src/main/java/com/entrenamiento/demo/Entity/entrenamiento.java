package com.entrenamiento.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity 
@Data 
public class entrenamiento {

    private LocalDate fecha;

    private Long session;

}