/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    /*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PERSONA_ID", nullable = false)*/
    @Column(name = "PERSONA_ID")
    private Integer persona;

    /*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ROL_ID", nullable = false)*/
    @Column(name = "ROL_ID")
    private Integer rol;

    @Column(name = "USUARIO_NOMBRE")
    private String usuario_nombre;

    @Column(name = "USUARIO_PASSWORD")
    private String usuario_password;

    @Column(name = "estado")
    private Boolean estado;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.usuario_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.usuario_id != other.usuario_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s", usuario_nombre);

    }

}
