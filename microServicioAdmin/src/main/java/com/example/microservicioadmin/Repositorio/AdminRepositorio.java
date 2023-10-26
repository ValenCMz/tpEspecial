package com.example.microservicioadmin.Repositorio;

import com.example.microservicioadmin.Modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepositorio extends JpaRepository<Admin,Long> {

    @Query("SELECT a FROM Admin a WHERE a.id_admin = :id")
    public Admin getPorId(long id);

    @Query("UPDATE Admin a SET a.nombre = :nombre WHERE a.id_admin = :id")
    public Admin update(long id, String nombre);
}
