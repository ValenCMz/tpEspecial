package com.example.microserviciomantenimiento.Controller;


import com.example.microserviciomantenimiento.Modelo.Mantenimiento;
import com.example.microserviciomantenimiento.Modelo.Monopatin;
import com.example.microserviciomantenimiento.Servicio.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/mantenimiento")
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Mantenimiento mantenimiento){

        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.mantenimientoService.save(mantenimiento));

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo guardar el Mantenimiento\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody Mantenimiento entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.mantenimientoService.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo editar el mantenimiento.\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.mantenimientoService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. no se pudo eliminar, intente nuevamente.");
        }
    }

    @PutMapping("/monopatin/{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody Monopatin monopatin){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.mantenimientoService.registrarMonopatinEnMantenimiento(id,monopatin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error. No se pudo poner en matenimiento el monopatin.");
        }
    }
}



