package com.example.microservicioparada.Controller;

import com.example.microservicioparada.Modelo.Parada;
import com.example.microservicioparada.Repositorio.ParadaRepositorio;
import com.example.microservicioparada.Servicio.ParadaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paradas")
public class ParadaController {

    @Autowired
    private ParadaServicio paradaServicio;

    @GetMapping("")
    public ResponseEntity<?> getParadas(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.paradaServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay paradas");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Parada parada){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.paradaServicio.save(parada));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar la parada");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Parada paradaActualizada){
        try{
            Parada parada = this.paradaServicio.findById(id);
            if(parada!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.paradaServicio.update(id,paradaActualizada));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parada no encontrada");
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo actualizar la parada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable long id){
        try{
            Parada parada =this.paradaServicio.findById(id);
            if(parada!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.paradaServicio.delete(id));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parada no encontrada");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo eliminar la parada");
        }
    }


}
