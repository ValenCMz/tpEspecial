package com.example.microserviciomonopatin.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_viaje;
    @Column
    private LocalDateTime fechaYHoraDeInicio;
    @Column
    private LocalDateTime fechaYHoraDeFinalizacion;
    @Column
    private double kmRecorridos;
    @Column
    private double precio;
    @Column
    private int id_usuario;
    @OneToOne
    private Monopatin monopatin;

    public Viaje(Long id_viaje, LocalDateTime fechaYHoraDeInicio, LocalDateTime fechaYHoraDeFinalizacion, double kmRecorridos, double precio, int id_usuario, Monopatin monopatin) {
        this.id_viaje = id_viaje;
        this.fechaYHoraDeInicio = fechaYHoraDeInicio;
        this.fechaYHoraDeFinalizacion = fechaYHoraDeFinalizacion;
        this.kmRecorridos = kmRecorridos;
        this.precio = precio;
        this.id_usuario = id_usuario;
        this.monopatin = monopatin;
    }

    public Viaje(){

    }

    public Long getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(Long id_viaje) {
        this.id_viaje = id_viaje;
    }

    public LocalDateTime getFechaYHoraDeInicio() {
        return fechaYHoraDeInicio;
    }

    public void setFechaYHoraDeInicio(LocalDateTime fechaYHoraDeInicio) {
        this.fechaYHoraDeInicio = fechaYHoraDeInicio;
    }

    public LocalDateTime getFechaYHoraDeFinalizacion() {
        return fechaYHoraDeFinalizacion;
    }

    public void setFechaYHoraDeFinalizacion(LocalDateTime fechaYHoraDeFinalizacion) {
        this.fechaYHoraDeFinalizacion = fechaYHoraDeFinalizacion;
    }

    public double getKmRecorridos() {
        return kmRecorridos;
    }

    public void setKmRecorridos(double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Monopatin getMonopatin() {
        return monopatin;
    }

    public void setMonopatin(Monopatin monopatin) {
        this.monopatin = monopatin;
    }
}
