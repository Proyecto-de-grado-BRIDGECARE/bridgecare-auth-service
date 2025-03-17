package com.bridgecare.auth.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "identificacion")
    private Long identificacion;

    @Column(name = "tipo_usuario")
    private Integer tipo_usuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "contrasenia")
    private String contrasenia;

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public Integer getTipo_usuario() {
        return tipo_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public void setTipo_usuario(Integer tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombres = " + nombres + ", " +
                "apellidos =" + apellidos + ", " +
                "identificacion =" + identificacion + ", " +
                "tipo_usuario =" + tipo_usuario + ", " +
                "correo =" + correo + ", " +
                "municipio =" + municipio + ")";
    }
}
