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
@Table (name="cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cliente_id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PERSONA_ID", nullable = false)
    private Persona persona;
    
    @Column(name = "CLIENTE_EDAD")
    private int cliente_edad;
    
    @Column(name = "CLIENTE_CORREO")
    private String cliente_correo;
    
    @Column(name = "CLIENTE_TELEFONO")
    private String cliente_telefono;

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.cliente_id;
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
        final Cliente other = (Cliente) obj;
        if (this.cliente_id != other.cliente_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente_id=" + cliente_id + '}';
    }
    
    
    
    
    
}
