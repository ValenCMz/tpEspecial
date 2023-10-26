package com.example.microservicioparada.Repositorio;

import com.example.microservicioparada.Modelo.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParadaRepositorio extends JpaRepository<Parada,Long> {


    @Query("SELECT u FROM Parada u WHERE u.id_parada = :id")
    public Parada getPorId(Long id);

    @Query("UPDATE Parada p SET p.cupo = :cupo,p.ubicacion = :ubicacion WHERE p.id_parada = :id")
    public Parada update(Long id, int cupo, String ubicacion);
}
