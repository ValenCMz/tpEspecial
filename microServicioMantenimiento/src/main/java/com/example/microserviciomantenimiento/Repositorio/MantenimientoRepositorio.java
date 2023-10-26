package com.example.microserviciomantenimiento.Repositorio;

import com.example.microserviciomantenimiento.Modelo.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MantenimientoRepositorio extends JpaRepository<Mantenimiento,Long> {

    @Query("Select c FROM Mantenimiento c WHERE c.id_mantenimiento = :id")
    public Mantenimiento getByID(long id);

    @Query("update Mantenimiento  m set m.encargado = :encargado where m.id_mantenimiento = :id ")
    Mantenimiento update(Long id, String encargado);
}
