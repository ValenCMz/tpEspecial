package com.example.microserviciomonopatin.Servicio;

import com.example.microserviciomonopatin.Modelo.Monopatin;
import com.example.microserviciomonopatin.Repositorio.MonoPatinRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("monopatinServicio")

public class MonoPatinServicio implements BaseService<Monopatin>{
    @Autowired
    private MonoPatinRepositorio monoPatinRepositorio;


    public List<Monopatin> findAll()throws Exception {
        return this.monoPatinRepositorio.findAll();
    }

    @Override
    public Monopatin findById(Long id) throws Exception {
        return this.monoPatinRepositorio.getById(id);
    }

    public Monopatin save(Monopatin entity)throws  Exception {
        return this.monoPatinRepositorio.save(entity);
    };

    public Monopatin update(Long id, Monopatin entity)throws Exception {
        this.monoPatinRepositorio.update(id,entity.getUbicacion(),entity.getTiempoDeUso(),entity.getKmsRecorridos(),entity.isDisponible(),entity.isMantenimiento());
        return this.findById(id);
    };

    public boolean delete(Long id)throws Exception {
        Monopatin m = this.findById(id);
        if (m == null){
            return false;
        }
        this.monoPatinRepositorio.deleteById(id);
        return true;
    };
}
