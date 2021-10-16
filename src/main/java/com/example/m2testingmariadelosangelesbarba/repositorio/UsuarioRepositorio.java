package com.example.m2testingmariadelosangelesbarba.repositorio;

import com.example.m2testingmariadelosangelesbarba.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario, Long>{

}
