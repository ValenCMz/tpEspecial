package com.example.microserviciomonopatin.Modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_monopatin;
    @Column
    private String ubicacion;
    @Column
    private double tiempoDeUso;
    @Column
    private double kmsRecorridos;
    @Column
    private boolean disponible;
    @Column
    private boolean mantenimiento;

    public Monopatin(int id_monopatin, String ubicacion, double tiempoDeUso, double kmsRecorridos, boolean disponible, boolean mantenimiento) {
        this.id_monopatin = id_monopatin;
        this.ubicacion = ubicacion;
        this.tiempoDeUso = tiempoDeUso;
        this.kmsRecorridos = kmsRecorridos;
        this.disponible = disponible;
        this.mantenimiento = mantenimiento;
    }

    public Monopatin() {

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
