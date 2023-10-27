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

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.mantenimientoService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay encargados de mantenimiento");
        }
    }

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
    public ResponseEntity<?> marcarMonopatinEnMantenimiento(@PathVariable long id) {
        System.out.println(id);
        Monopatin monopatin = mantenimientoService.registrarMonopatinEnMantenimiento(id);
        if (monopatin != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Monopatin marcado en mantenimiento con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al marcar el monopatín en mantenimiento");
        }
    }
}



