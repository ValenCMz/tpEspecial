package com.example.microserviciomantenimiento.Servicio;

import com.example.microserviciomantenimiento.Modelo.Mantenimiento;
import com.example.microserviciomantenimiento.Modelo.Monopatin;
import com.example.microserviciomantenimiento.Repositorio.MantenimientoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.Media;
import java.util.List;

@Service
public class MantenimientoService implements BaseService<Mantenimiento> {

    @Autowired
    private MantenimientoRepositorio mantenimientoRepositorio;
    @Autowired
    private RestTemplate mantenimientoRest;
    @Override
    public List<Mantenimiento> findAll() throws Exception {
        return this.mantenimientoRepositorio.findAll();
    }

    @Override
    public Mantenimiento findById(Long id) throws Exception {
        return this.mantenimientoRepositorio.getById(id);
    }

    @Override
    @Transactional
    public Mantenimiento save(Mantenimiento entity) throws Exception {
        try {
            return this.mantenimientoRepositorio.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Mantenimiento update(Long id, Mantenimiento entity) throws Exception {
        return this.mantenimientoRepositorio.update(id, entity.encargado);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Mantenimiento p = this.mantenimientoRepositorio.getByID(id);
        if (p == null) {
            return false;
        }
        this.mantenimientoRepositorio.deleteById(id);
        return true;
    }

    public Monopatin registrarMonopatinEnMantenimiento(long id, Monopatin monopatin){
        Monopatin m = new Monopatin(monopatin.getUbicacion(),monopatin.getTiempoDeUso(),monopatin.getKmsRecorridos(),monopatin.isDisponible(),monopatin.isMantenimiento());
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Monopatin>response = mantenimientoRest.exchange(
                "http://localhost:8003/monopatin/" + id,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<Monopatin>() {}

        );
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(response);
        return null;
    }

}