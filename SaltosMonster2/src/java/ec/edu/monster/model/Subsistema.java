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
@Table (name="subsistema")
public class Subsistema implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subsistema_id;
      
    /*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ROL_ID", nullable = false)*/
    @Column(name = "ROL_ID")
    private Integer rol_id;
    
    @Column(name = "SUBSISTEMA_DESCRIPCION")
    private String subsistema_descripcion;  

    public int getSubsistema_id() {
        return subsistema_id;
    }

    public void setSubsistema_id(int subsistema_id) {
        this.subsistema_id = subsistema_id;
    }

    public Integer getRol_id() {
        return rol_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }



    public String getSubsistema_descripcion() {
        return subsistema_descripcion;
    }

    public void setSubsistema_descripcion(String subsistema_descripcion) {
        this.subsistema_descripcion = subsistema_descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.subsistema_id;
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
        final Subsistema other = (Subsistema) obj;
        if (this.subsistema_id != other.subsistema_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s",subsistema_descripcion);
    }
    
    
}
