package com.example.microserviciousuario.Repositorio;

import com.example.microserviciousuario.Modelo.Cuenta;
import com.example.microserviciousuario.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CuentaRepositorio extends JpaRepository<Cuenta,Long> {

    @Query("Select c FROM Cuenta c WHERE c.id_cuenta = :id")
    public Cuenta getByID(Long id);
    @Query("UPDATE Cuenta SET email = :email WHERE id_cuenta = :id")
    public void update(Long id,String email);
}
