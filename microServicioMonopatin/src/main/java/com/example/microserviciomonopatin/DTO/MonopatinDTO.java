package com.example.microserviciomonopatin.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class MonopatinDTO {

    private int id_monopatin;

    private String ubicacion;

    private double tiempoDeUso;

    private double kmsRecorridos;

    private boolean disponible;

    private boolean mantenimiento;

    public MonopatinDTO(int id_monopatin, String ubicacion, double tiempoDeUso, double kmsRecorridos, boolean disponible, boolean mantenimiento) {
        this.id_monopatin = id_monopatin;
        this.ubicacion = ubicacion;
        this.tiempoDeUso = tiempoDeUso;
        this.kmsRecorridos = kmsRecorridos;
        this.disponible = disponible;
        this.mantenimiento = mantenimiento;
    }

    @Override
    public String toString() {
        return "MonopatinDTO{" +
                "id_monopatin=" + id_monopatin +
                ", ubicacion='" + ubicacion + '\'' +
                ", tiempoDeUso=" + tiempoDeUso +
                ", kmsRecorridos=" + kmsRecorridos +
                ", disponible=" + disponible +
                ", mantenimiento=" + mantenimiento +
                '}';
    }
}
