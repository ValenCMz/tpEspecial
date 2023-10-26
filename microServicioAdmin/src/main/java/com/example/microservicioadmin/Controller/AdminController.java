package com.example.microservicioadmin.Controller;


import com.example.microservicioadmin.Modelo.Admin;
import com.example.microservicioadmin.Modelo.Monopatin;
import com.example.microservicioadmin.Servicio.AdminServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServicio servicioAdmin;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.servicioAdmin.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay cuentas");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Admin admin){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.servicioAdmin.save(admin));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar el/la admin");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Admin cuentaActualizada){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.servicioAdmin.update(id,cuentaActualizada));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo actualizar el/la admin");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            boolean result = this.servicioAdmin.delete(id);
            if (!result){
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El admin a borrar no existe");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Admin borrado existosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo borrar el admin");
        }
    }

    @PostMapping("/Monopatin")
    public ResponseEntity<?>insert(@RequestBody Monopatin monopatin) {
        monopatin.toString();
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.servicioAdmin.agregarMonopatin(monopatin));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar el/la admin");
        }
    }
}
