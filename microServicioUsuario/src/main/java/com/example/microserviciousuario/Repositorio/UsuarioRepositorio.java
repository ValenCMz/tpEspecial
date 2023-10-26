package com.example.microserviciousuario.Repositorio;

import com.example.microserviciousuario.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.id_usuario = :id")
    public Usuario getPorId(Long id);

    @Query("UPDATE Usuario  u SET u.nombre = :nombre, u.apellido = :apellido, u.telefono= :telefono, u.fechaDeAlta = :fechaDeAlta, u.username = :userName, u.admin = :admin WHERE u.id_usuario = :id")
    Usuario update(Long id, String nombre, String apellido, int telefono, Date fechaDeAlta, String userName, boolean admin);
}
