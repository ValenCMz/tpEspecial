package com.example.microservicioadmin.Servicio;

import com.example.microservicioadmin.Config.AppConfig;
import com.example.microservicioadmin.Modelo.Admin;
import com.example.microservicioadmin.Modelo.Monopatin;
import com.example.microservicioadmin.Repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class AdminServicio implements BaseService<Admin> {

    @Autowired
    private AdminRepositorio adminRepositorio;
    @Autowired
    private RestTemplate adminRest;

    @Override
    public List<Admin> findAll() throws Exception {
        return this.adminRepositorio.findAll();
    }

    @Override
    public Admin findById(Long id) throws Exception {
        return this.adminRepositorio.getPorId(id);
    }

    @Override
    public Admin save(Admin entity) throws Exception {
        return this.adminRepositorio.save((entity));
    }

    @Override
    public Admin update(Long id, Admin entity) throws Exception {
        return this.adminRepositorio.update(id,entity.getNombre());
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Admin p = this.adminRepositorio.getPorId(id);
        if (p == null){
            return false;
        }
        this.adminRepositorio.deleteById(id);
        return true;
    }

    public ResponseEntity agregarMonopatin(Monopatin monopatin){
        HttpHeaders headers = new HttpHeaders();
        Monopatin m = new Monopatin(monopatin.getUbicacion(),monopatin.getTiempoDeUso(),monopatin.getKmsRecorridos(),monopatin.isDisponible(),monopatin.isMantenimiento());
        HttpEntity<Monopatin> requestEntity = new HttpEntity<>(m,headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<String> response = adminRest.exchange(
                "http://localhost:8003/monopatin",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return response;
    }
}
