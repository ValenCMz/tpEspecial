package com.example.microserviciomonopatin.controllers;

import com.example.microserviciomonopatin.Modelo.Viaje;
import com.example.microserviciomonopatin.Servicio.ViajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeServicio viajeServicio;

    @GetMapping("")
    public ResponseEntity<?> getUsuarios(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.viajeServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay viajes");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Viaje viaje){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.viajeServicio.save(viaje));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar el viaje");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Viaje viajeActualizado){
        try{
            Viaje viaje = this.viajeServicio.findById(id);
            if(viaje!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.viajeServicio.update(id,viajeActualizado));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo actualizar el usuario");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable long id){
        try{
            Viaje viaje =this.viajeServicio.findById(id);
            if(viaje!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.viajeServicio.delete(id));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Viaje no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo eliminar el Viaje");
        }
    }
}
