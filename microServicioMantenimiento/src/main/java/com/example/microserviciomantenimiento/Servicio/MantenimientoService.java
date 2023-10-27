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

    public Monopatin registrarMonopatinEnMantenimiento(long id) {
        // Paso 1: Realizar una solicitud GET para obtener el monopatín actual
        ResponseEntity<Monopatin> response = obtenerMonopatinPorId(id);

        if (response.getStatusCode() == HttpStatus.OK) {
            Monopatin monopatinRespuesta = response.getBody();

            // Paso 2: Marcar el monopatín como en mantenimiento
            if (monopatinRespuesta != null) {
                monopatinRespuesta.setMantenimiento(true);

                // Paso 3: Realizar una solicitud PUT para actualizar el monopatín
                ResponseEntity<Monopatin> respuestaActualizacion = actualizarMonopatin(id, monopatinRespuesta);

                if (respuestaActualizacion.getStatusCode() == HttpStatus.OK) {
                    // Devolver el monopatín actualizado
                    return respuestaActualizacion.getBody();
                }
            }
        }

        // Si algo falla, devolver null o manejar el error de manera adecuada
        return null;
    }

    private ResponseEntity<Monopatin> obtenerMonopatinPorId(long id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<Monopatin> response = mantenimientoRest.exchange(
                "http://localhost:8003/monopatin/" + id,
                HttpMethod.GET,
                requestEntity,
                Monopatin.class
        );

        return response;
    }

    private ResponseEntity<Monopatin> actualizarMonopatin(long id, Monopatin monopatin) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Monopatin> requestEntity = new HttpEntity<>(monopatin, headers);
        ResponseEntity<Monopatin> response = mantenimientoRest.exchange(
                "http://localhost:8003/monopatin/" + id,
                HttpMethod.PUT,
                requestEntity,
                Monopatin.class
        );

        return response;
    }

}