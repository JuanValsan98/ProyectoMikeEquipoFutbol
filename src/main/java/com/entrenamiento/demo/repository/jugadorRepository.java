package com.entrenamiento.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.entrenamiento.demo.Entity.jugador;

public interface jugadorRepository extends JpaRepository<jugador, Long>{
    
}
