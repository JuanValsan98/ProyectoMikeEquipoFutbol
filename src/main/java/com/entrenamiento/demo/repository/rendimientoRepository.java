package com.entrenamiento.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entrenamiento.demo.Entity.rendimientojugador;
import com.entrenamiento.demo.Entity.jugador;

@Repository 
public interface rendimientoRepository extends JpaRepository<rendimientojugador, Long> {



    
} 