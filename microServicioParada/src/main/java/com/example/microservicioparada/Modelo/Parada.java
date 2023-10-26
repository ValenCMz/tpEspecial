package com.example.microservicioparada.Modelo;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_parada;
    @Column
    private int cupo;
    @Column
    private String ubicacion;
    @ElementCollection
    @CollectionTable(name = "parada_monopatines", joinColumns = @JoinColumn(name = "parada_id"))
    @Column(name = "monopatin_id")
    private List<Long> monopatines;

    public int getId_parada() {
        return id_parada;
    }

    public void setId_parada(int id_parada) {
        this.id_parada = id_parada;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
