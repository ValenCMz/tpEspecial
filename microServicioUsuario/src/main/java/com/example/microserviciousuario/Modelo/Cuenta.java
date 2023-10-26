package com.example.microserviciousuario.Modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cuenta;
    @Column
    private String email;

    @OneToMany(mappedBy = "cuenta")
    private List<CuentaUsuario> usuarios;

    public Cuenta(int id_cuenta, String email) {
        this.id_cuenta = id_cuenta;
        this.email = email;
    }

    public Cuenta() {
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addUsuario(CuentaUsuario cu){
        this.usuarios.add(cu);
    }
}
