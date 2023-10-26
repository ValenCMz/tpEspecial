package com.example.microserviciousuario.Modelo;

import jakarta.persistence.*;

@Entity
public class CuentaUsuario {
    @EmbeddedId
    private CuentaUsuarioKey id;

    @ManyToOne
    @MapsId("idCuenta")
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public CuentaUsuario(CuentaUsuarioKey id, Cuenta cuenta, Usuario usuario) {
        this.id = id;
        this.cuenta = cuenta;
        this.usuario = usuario;
    }

    public CuentaUsuario() {

    }


    public CuentaUsuarioKey getId() {
        return id;
    }

    public void setId(CuentaUsuarioKey id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
