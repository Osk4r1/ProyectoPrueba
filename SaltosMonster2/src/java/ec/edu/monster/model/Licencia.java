/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author danie
 */

@Entity
@Table (name = "licencia")
public class Licencia implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int licencia_id;
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;
    
    @Column(name = "PARACAIDISTA_ID")
    private int paracaidista_id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "LICENCIA_CADUCIDAD")
    private Date licencia_caducidad;
    
    @Column(name = "LICENCIA_TIPO")
    private String licencia_tipo;

    public int getLicencia_id() {
        return licencia_id;
    }

    public void setLicencia_id(int licencia_id) {
        this.licencia_id = licencia_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getParacaidista_id() {
        return paracaidista_id;
    }

    public void setParacaidista_id(int paracaidista_id) {
        this.paracaidista_id = paracaidista_id;
    }

    public Date getLicencia_caducidad() {
        return licencia_caducidad;
    }

    public void setLicencia_caducidad(Date licencia_caducidad) {
        this.licencia_caducidad = licencia_caducidad;
    }

    public String getLicencia_tipo() {
        return licencia_tipo;
    }

    public void setLicencia_tipo(String licencia_tipo) {
        this.licencia_tipo = licencia_tipo;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.licencia_id;
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
        final Licencia other = (Licencia) obj;
        if (this.licencia_id != other.licencia_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Licencia{" + "licencia_id=" + licencia_id + '}';
    }
    
    
    
}
