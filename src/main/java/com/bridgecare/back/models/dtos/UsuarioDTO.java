package com.bridgecare.back.models.dtos;

public class UsuarioDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private Long identificacion;
    private Integer tipo_usuario;
    private String correo;
    private String municipio;
    private String contrasenia;

    public UsuarioDTO(Long id, String nombres, String apellidos, Long identificacion, Integer tipo_usuario, String correo, String municipio, String contrasenia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.tipo_usuario = tipo_usuario;
        this.correo = correo;
        this.municipio = municipio;
        this.contrasenia = contrasenia;
    }

    public UsuarioDTO(Long id, String nombres, String apellidos, Long identificacion, Integer tipo_usuario, String correo, String municipio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.tipo_usuario = tipo_usuario;
        this.correo = correo;
        this.municipio = municipio;
    }
    
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
}
