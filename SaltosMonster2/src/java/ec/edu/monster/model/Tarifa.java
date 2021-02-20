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
@Table (name="tarifa")
public class Tarifa implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      
    private int tarifa_id;
    
    @Column(name = "TARIFA_COSTO")
    private Double tarifa_costo;

    public int getTarifa_id() {
        return tarifa_id;
    }

    public void setTarifa_id(int tarifa_id) {
        this.tarifa_id = tarifa_id;
    }

    public Double getTarifa_costo() {
        return tarifa_costo;
    }

    public void setTarifa_costo(Double tarifa_costo) {
        this.tarifa_costo = tarifa_costo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.tarifa_id;
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
        final Tarifa other = (Tarifa) obj;
        if (this.tarifa_id != other.tarifa_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "tarifa_id=" + tarifa_id + '}';
    }
    
    
    
}
