package com.example.microserviciousuario.Controller;


import com.example.microserviciousuario.Modelo.Cuenta;
import com.example.microserviciousuario.Modelo.Usuario;
import com.example.microserviciousuario.Servicio.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaServicio cuentaServicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.cuentaServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay cuentas");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Cuenta cuenta){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.cuentaServicio.save(cuenta));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar la cuenta");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Cuenta cuentaActualizada){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.cuentaServicio.update(id,cuentaActualizada));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo actualizar la cuenta");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            boolean result = this.cuentaServicio.delete(id);
            if (!result){
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La cuenta a borrar no existe");
            }
            return ResponseEntity.status(HttpStatus.OK).body("Cuenta borrado existosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo borrar la cuenta");
        }
    }


}
