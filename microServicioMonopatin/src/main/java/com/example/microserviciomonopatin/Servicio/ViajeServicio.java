package com.example.microserviciomonopatin.Servicio;

import com.example.microserviciomonopatin.Modelo.Viaje;
import com.example.microserviciomonopatin.Repositorio.ViajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ViajeServicio")
public class ViajeServicio implements BaseService<Viaje>{

    @Autowired
    ViajeRepositorio viajeRepositorio;
    @Override
    public List<Viaje> findAll() throws Exception {
        return this.viajeRepositorio.findAll();
    }

    @Override
    public Viaje findById(Long id) throws Exception {
        return this.viajeRepositorio.getPorId(id);
    }

    @Override
    public Viaje save(Viaje entity) throws Exception {
        return this.viajeRepositorio.save(entity);
    }

    @Override
    public Viaje update(Long id, Viaje entity) throws Exception {
        return this.viajeRepositorio.update(id,entity.getId_usuario(),entity.getFechaYHoraDeFinalizacion(),entity.getFechaYHoraDeInicio(),entity.getKmRecorridos(),entity.getPrecio(),entity.getMonopatin().getId_monopatin());
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Viaje v = this.viajeRepositorio.getPorId(id);
        if (v == null){
            return false;
        }
        this.viajeRepositorio.deleteById(id);
        return true;
    }
}
