package com.example.microservicioadmin.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_admin;

    @Column
    private String nombre;


    public Admin(int id_admin, String nombre) {
        this.id_admin = id_admin;
        this.nombre = nombre;
    }

    public Admin() {
    }
}
