package com.example.microserviciousuario.Modelo;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_usuario;
    @Column
    private String username;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int telefono;
    @Column
    private Date fechaDeAlta;
    @Column
    private boolean admin;

    @OneToMany(mappedBy = "usuario")
    private List<CuentaUsuario>cuentas;


    public Usuario(int id_usuario,String username,String nombre,String apellido,int telefono,Date fechaDeAlta,boolean admin){
        this.id_usuario = id_usuario;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaDeAlta = fechaDeAlta;
        this.admin = admin;
    }


    public Usuario() {

    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void addCuenta(CuentaUsuario cu){
        this.cuentas.add(cu);
    }
}
