package com.example.microserviciomantenimiento.Modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class Monopatin implements Serializable {

    private int id_monopatin;

    @JsonProperty
    private String ubicacion;
    @JsonProperty
    private double tiempoDeUso;
    @JsonProperty
    private double kmsRecorridos;
    @JsonProperty
    private boolean disponible;
    @JsonProperty
    private boolean mantenimiento;

    public Monopatin(int id_monopatin, String ubicacion, double tiempoDeUso, double kmsRecorridos, boolean disponible) {
        this.id_monopatin = id_monopatin;
        this.ubicacion = ubicacion;
        this.tiempoDeUso = tiempoDeUso;
        this.kmsRecorridos = kmsRecorridos;
        this.disponible = disponible;
    }

    public Monopatin(String ubicacion, double tiempoDeUso, double kmsRecorridos, boolean disponible, boolean mantenimiento) {
        this.ubicacion = ubicacion;
        this.tiempoDeUso = tiempoDeUso;
        this.kmsRecorridos = kmsRecorridos;
        this.disponible = disponible;
        this.mantenimiento = mantenimiento;
    }

    public Monopatin() {
    }

    @Override
    public String toString() {
        return "Monopatin{" +
                "id_monopatin=" + id_monopatin +
                ", ubicacion='" + ubicacion + '\'' +
                ", tiempoDeUso=" + tiempoDeUso +
                ", kmsRecorridos=" + kmsRecorridos +
                ", disponible=" + disponible +
                '}';
    }

    public int getId_monopatin() {
        return id_monopatin;
    }

    public void setId_monopatin(int id_monopatin) {
        this.id_monopatin = id_monopatin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getTiempoDeUso() {
        return tiempoDeUso;
    }

    public void setTiempoDeUso(double tiempoDeUso) {
        this.tiempoDeUso = tiempoDeUso;
    }

    public double getKmsRecorridos() {
        return kmsRecorridos;
    }

    public void setKmsRecorridos(double kmsRecorridos) {
        this.kmsRecorridos = kmsRecorridos;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(boolean mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
}

