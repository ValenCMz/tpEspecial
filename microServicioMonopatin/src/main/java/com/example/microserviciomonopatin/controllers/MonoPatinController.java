package com.example.microserviciomonopatin.controllers;

import com.example.microserviciomonopatin.Modelo.Monopatin;
import com.example.microserviciomonopatin.Servicio.MonoPatinServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/monopatin")
public class MonoPatinController {

    @Autowired
    private MonoPatinServicio monoPatinServicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.monoPatinServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay monopatines");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Monopatin cuenta){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.monoPatinServicio.save(cuenta));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar el monopatin");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Monopatin cuentaActualizada){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.monoPatinServicio.update(id,cuentaActualizada));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo actualizar el monopatin");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            boolean result = this.monoPatinServicio.delete(id);
            if (!result){
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El monopatin a borrar no existe");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Monopatin borrado existosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo borrar el monopatin");
        }
    }


}
