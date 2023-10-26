package com.example.microserviciomantenimiento.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mantenimiento;
    @Column
    public String encargado;
    @ElementCollection
    @CollectionTable(name = "mantenimiento_monopatines", joinColumns = @JoinColumn(name = "mantenimiento_id"))
    @Column(name = "monopatin_id")
    private List<Long> monopatines;
}
