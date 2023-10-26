package com.example.microserviciousuario.Controller;

import com.example.microserviciousuario.Modelo.Usuario;
import com.example.microserviciousuario.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("")
    public ResponseEntity<?>getUsuarios(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.usuarioServicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no hay usuarios");
        }
    }

    @PostMapping("")
    public ResponseEntity<?>insert(@RequestBody Usuario usuario){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.usuarioServicio.save(usuario));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo insertar el usuario");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable long id, @RequestBody Usuario usuarioActualizado){
        try{
            Usuario usuario = this.usuarioServicio.findById(id);
            if(usuario!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.usuarioServicio.update(id,usuarioActualizado));
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
            Usuario usuario =this.usuarioServicio.findById(id);
            if(usuario!=null){
                return ResponseEntity.status(HttpStatus.OK).body(this.usuarioServicio.delete(id));
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, no se pudo eliminar el usuario");
        }
    }
}
