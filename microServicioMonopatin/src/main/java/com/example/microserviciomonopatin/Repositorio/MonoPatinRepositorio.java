package com.example.microserviciomonopatin.Repositorio;

import com.example.microserviciomonopatin.Modelo.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MonoPatinRepositorio extends JpaRepository<Monopatin,Long> {
    @Query("SELECT m FROM Monopatin m WHERE m.id_monopatin = :id")
    public Monopatin getById(long id);

    @Query("UPDATE Monopatin m SET m.ubicacion = :ubicacion,m.tiempoDeUso = :tiempoDeUso, m.kmsRecorridos = :kmsRecorridos, m.disponible = :disponible, m.mantenimiento = :mantenimiento WHERE m.id_monopatin = :id")
    public void update(long id,String ubicacion,double tiempoDeUso,double kmsRecorridos,boolean disponible,boolean mantenimiento);
}
