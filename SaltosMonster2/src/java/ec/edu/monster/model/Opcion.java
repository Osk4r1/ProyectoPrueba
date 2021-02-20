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
@Table (name="opcion")
public class Opcion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int opcion_id;
      
    
    /*
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "SUBSISTEMA_ID", nullable = false)*/
    @Column(name = "SUBSISTEMA_ID")
    private Integer subsistema_id;
    
    @Column(name = "OPCION_DESCRIPCION")
    private String opcion_descripcion;      
    
    @Column(name = "OPCION_VISTA")
    private String opcion_vista; 

    public int getOpcion_id() {
        return opcion_id;
    }

    public void setOpcion_id(int opcion_id) {
        this.opcion_id = opcion_id;
    }

    public Integer getSubsistema() {
        return subsistema_id;
    }

    public void setSubsistema(Integer subsistema) {
        this.subsistema_id = subsistema;
    }



    public String getOpcion_descripcion() {
        return opcion_descripcion;
    }

    public void setOpcion_descripcion(String opcion_descripcion) {
        this.opcion_descripcion = opcion_descripcion;
    }

    public String getOpcion_vista() {
        return opcion_vista;
    }

    public void setOpcion_vista(String opcion_vista) {
        this.opcion_vista = opcion_vista;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.opcion_id;
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
        final Opcion other = (Opcion) obj;
        if (this.opcion_id != other.opcion_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s", opcion_descripcion);
    }
    
    
}
