package com.example.microservicioparada.Servicio;

import com.example.microservicioparada.Modelo.Parada;
import com.example.microservicioparada.Repositorio.ParadaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ParadaServicio")
public class ParadaServicio implements BaseService<Parada>{
    @Autowired
    private ParadaRepositorio paradaRepositorio;
    @Override
    public List<Parada> findAll() throws Exception {
        return this.paradaRepositorio.findAll();
    }

    @Override
    public Parada findById(Long id) throws Exception {
        return this.paradaRepositorio.getPorId(id);
    }

    @Override
    public Parada save(Parada entity) throws Exception {
        return this.paradaRepositorio.save(entity);
    }

    @Override
    public Parada update(Long id, Parada entity) throws Exception {

        return this.paradaRepositorio.update(id,entity.getCupo(),entity.getUbicacion());
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Parada p = this.paradaRepositorio.getPorId(id);
        if (p == null){
            return false;
        }
        this.paradaRepositorio.deleteById(id);
        return true;
    }

}
