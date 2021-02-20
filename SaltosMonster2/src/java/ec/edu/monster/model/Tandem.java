/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author danie
 */
@Entity
@Table (name="tandem")
public class Tandem implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int tandem_id;
    
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;
    
    @Column(name = "PERSONA_ID")
    private int persona_id;
    
    @Column(name = "VUELO_ID")
    private int vuelo_id;
    
    @Column(name = "TANDEM_DESCRIPCION")
    private String tandem_descripcion;    

    public int getTandem_id() {
        return tandem_id;
    }

    public void setTandem_id(int tandem_id) {
        this.tandem_id = tandem_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public String getTandem_descripcion() {
        return tandem_descripcion;
    }

    public void setTandem_descripcion(String tandem_descripcion) {
        this.tandem_descripcion = tandem_descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.tandem_id;
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
        final Tandem other = (Tandem) obj;
        if (this.tandem_id != other.tandem_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tandem{" + "tandem_id=" + tandem_id + '}';
    }
    
    
    
    
}
