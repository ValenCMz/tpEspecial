package com.example.microserviciomonopatin.Repositorio;

import com.example.microserviciomonopatin.Modelo.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ViajeRepositorio extends JpaRepository<Viaje, Long> {

    @Query("SELECT v FROM Viaje v WHERE v.id_viaje = :id")
    public Viaje getPorId(long id);

    @Query("UPDATE Viaje v SET v.id_usuario = :idUsuario, v.fechaYHoraDeFinalizacion = :fechaFinalizacion,v.fechaYHoraDeInicio = :fechaInicio,v.kmRecorridos = :kmRecorridos, v.precio = :precio,v.monopatin.id_monopatin = :idMonopatin")
    public Viaje update(long id, int idUsuario, LocalDateTime fechaFinalizacion,LocalDateTime fechaInicio, double kmRecorridos, double precio, int idMonopatin);
}
