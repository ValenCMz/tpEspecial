package com.example.microserviciousuario.Servicio;

import com.example.microserviciousuario.Modelo.Usuario;
import com.example.microserviciousuario.Repositorio.UsuarioRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("UsuarioServicio")
public class UsuarioServicio implements BaseService<Usuario> {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    @Transactional
    public List<Usuario> findAll() throws Exception {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    @Transactional
    public Usuario findById(Long id) throws Exception {
        return this.usuarioRepositorio.getPorId(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario entity) throws Exception {
        return this.usuarioRepositorio.save(entity);
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario entity) throws Exception {
        String nombre =  entity.getNombre();
        String apellido = entity.getApellido();
        int telefono = entity.getTelefono();
        Date fechaDeAlta = entity.getFechaDeAlta();
        String userName = entity.getUsername();
        boolean admin = entity.isAdmin();
        return this.usuarioRepositorio.update(id,nombre,apellido,telefono,fechaDeAlta,userName,admin);
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        Usuario p = this.usuarioRepositorio.getPorId(id);
        if (p == null){
            return false;
        }
        this.usuarioRepositorio.deleteById(id);
        return true;
    }
}
