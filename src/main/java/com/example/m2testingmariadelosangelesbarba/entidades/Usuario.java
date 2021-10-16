package com.example.m2testingmariadelosangelesbarba.entidades;

//JPA (Java Persistence Api) hibernate
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

    //Atributos
        //Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        //Datos
    private String name;
    private Integer edad;
    private String ciudad;
    private String email;
    private Boolean autorizado;
        //Asociaciones

    //Constructores

    public Usuario() { }
    public Usuario(Long id, String name, Integer edad, String ciudad, String email, Boolean autorizado) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.ciudad = ciudad;
        this.email = email;
        this.autorizado = autorizado;
    }

    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }

    //ToString

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", email='" + email + '\'' +
                ", autorizado=" + autorizado +
                '}';
    }
}
