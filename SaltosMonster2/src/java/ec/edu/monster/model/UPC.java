/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.model;

/**
 *
 * @author danie
 */
public class UPC {
    private int persona_id;
    private String persona_nombres;
    private String persona_apellidos;
    private String persona_cedula;
    
    
    private int usuario_id;
    private int rol_id;
    private String usuario_nombre;
    private String usuario_password;
    
    private int cliente_id;
    private int cliente_edad;
    private String cliente_correo;
    private String cliente_telefono;

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getPersona_nombres() {
        return persona_nombres;
    }

    public void setPersona_nombres(String persona_nombres) {
        this.persona_nombres = persona_nombres;
    }

    public String getPersona_apellidos() {
        return persona_apellidos;
    }

    public void setPersona_apellidos(String persona_apellidos) {
        this.persona_apellidos = persona_apellidos;
    }

    public String getPersona_cedula() {
        return persona_cedula;
    }

    public void setPersona_cedula(String persona_cedula) {
        this.persona_cedula = persona_cedula;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_password() {
        return usuario_password;
    }

    public void setUsuario_password(String usuario_password) {
        this.usuario_password = usuario_password;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getCliente_edad() {
        return cliente_edad;
    }

    public void setCliente_edad(int cliente_edad) {
        this.cliente_edad = cliente_edad;
    }

    public String getCliente_correo() {
        return cliente_correo;
    }

    public void setCliente_correo(String cliente_correo) {
        this.cliente_correo = cliente_correo;
    }

    public String getCliente_telefono() {
        return cliente_telefono;
    }

    public void setCliente_telefono(String cliente_telefono) {
        this.cliente_telefono = cliente_telefono;
    }
    
    
    
    
}
