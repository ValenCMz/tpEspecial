package com.example.microserviciousuario.Servicio;


import com.example.microserviciousuario.Modelo.Cuenta;
import com.example.microserviciousuario.Modelo.Usuario;
import com.example.microserviciousuario.Repositorio.CuentaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CuentaServicio")
public class CuentaServicio implements BaseService<Cuenta> {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    @Override
    @Transactional
    public List<Cuenta> findAll() throws Exception {
        return this.cuentaRepositorio.findAll();
    }

    @Override
    @Transactional
    public Cuenta findById(Long id) throws Exception {
        return this.cuentaRepositorio.getByID(id);
    }

    @Override
    @Transactional
    public Cuenta save(Cuenta entity) throws Exception {
        return this.cuentaRepositorio.save(entity);
    }

    @Override
    @Transactional
    public Cuenta update(Long id, Cuenta entity) throws Exception {
        this.cuentaRepositorio.update(id,entity.getEmail());
        return this.findById(id);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        Cuenta c = this.findById(id);
        if (c == null){
            return false;
        }
        this.cuentaRepositorio.deleteById(id);
        return true;
    }
}
