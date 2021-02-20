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
@Table (name="adicional")
public class Adicional implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private int adicional_id;
    
    @Column(name = "TARIFA_ID")
    private int tarifa_id;
    
    @Column(name = "CAMAROGRAFO_ID")
    private Double camarografo_id;
    
    @Column(name = "EQUIPO_ID")
    private Double equipo_id;

    public int getAdicional_id() {
        return adicional_id;
    }

    public void setAdicional_id(int adicional_id) {
        this.adicional_id = adicional_id;
    }

    public int getTarifa_id() {
        return tarifa_id;
    }

    public void setTarifa_id(int tarifa_id) {
        this.tarifa_id = tarifa_id;
    }

    public Double getCamarografo_id() {
        return camarografo_id;
    }

    public void setCamarografo_id(Double camarografo_id) {
        this.camarografo_id = camarografo_id;
    }

    public Double getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Double equipo_id) {
        this.equipo_id = equipo_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.adicional_id;
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
        final Adicional other = (Adicional) obj;
        if (this.adicional_id != other.adicional_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Adicional{" + "adicional_id=" + adicional_id + '}';
    }
    
    
    
    
}
