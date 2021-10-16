package com.example.m2testingmariadelosangelesbarba.controlador;

import com.example.m2testingmariadelosangelesbarba.entidades.Usuario;
import com.example.m2testingmariadelosangelesbarba.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioControlador {
    UsuarioRepositorio repositorio;
    //Constructor
    public UsuarioControlador(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    //Método para introducir datos de prueba
    @GetMapping("/datos")
    public void demodatos(){
        Usuario alumno1 = new Usuario(null, "Pedro Pérez", 23, "Las Palmas de Gran Canaria", "pedroperez@email.com", true);
        Usuario alumno2 = new Usuario(null, "Ariadna Artiles", 21, "Santa Cruz de Tenerife", "ariadnaartiles@email.com", false);
        repositorio.save(alumno1);
        repositorio.save(alumno2);
    }

    //  Ejemplo de JSON para POSTMAN
    //       {"id": null,
    //        "name": "Maria Carey",
    //        "edad": 20,
    //        "ciudad": "Las Palmas de Gran Canaria",
    //        "email": "mariacarey@email.com",
    //        "autorizado": true}
    //Método para crear un usuario
    //El Id es null porque los estamos creando
    @PostMapping("/usuarios")
    public void create(@RequestBody Usuario usuario){
        if (usuario.getId() == null)
            repositorio.save(usuario);
    }

    //Método para buscar todos los usuarios de la BD
    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return repositorio.findAll();
    }

    //Método para buscar un usuario por id
    @GetMapping("/usuario/{id}")
    public Usuario findById(@PathVariable Long id){
           Optional<Usuario> usuariobuscado;
        Usuario user = new Usuario();
           if ((id != null) && (repositorio.existsById(id))) {
               usuariobuscado = repositorio.findById(id);
               if (usuariobuscado.isPresent())
                   user = usuariobuscado.get();
           }
           return  user;
       }

    //Método para modificar un usuario
    //El Id es distinto de null porque lo estamos actualizando
    @PutMapping("/usuarios")
    public void update(@RequestBody Usuario usuario){
        if ((usuario.getId() != null) && repositorio.existsById(usuario.getId()))
        repositorio.save(usuario);
    }
    //Método para borrar un usuario
    //No funciona bien con id que no existen
    @DeleteMapping("/usuarios/{id}")
    public void deleteById(@PathVariable Long id){
        if ((id != null) && (repositorio.existsById(id)))
        repositorio.deleteById(id);
    }

    //Método para borrar todos los usuarios
    @DeleteMapping("/borrar")
    public void deleteAll() {
        repositorio.deleteAll();
    }
    //Método para contar el númeoro de usuarios
    //Método para comprobar que existe un usuario por id
}
