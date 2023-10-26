package com.example.microserviciousuario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CuentaUsuarioKey implements Serializable {

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "id_cuenta")
    private int id_cuenta;

    public CuentaUsuarioKey(int id_usuario, int id_cuenta) {
        this.id_usuario = id_usuario;
        this.id_cuenta = id_cuenta;
    }

    public CuentaUsuarioKey() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
}
