/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.model;

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
@Table (name = "vuelo")
public class Vuelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    private int vuelo_id;
    
    @Column(name = "HORARIO_ID")   
    private int horario_id;
    
    @Column(name = "VUELO_CODIGO")  
    private String vuelo_codigo;
    
    @Column(name = "VUELO_AVION")
    private String vuelo_avion;
    
    @Column(name = "VUELO_CAPACIDAD")
    private int vuelo_capacidad;

    public int getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public String getVuelo_codigo() {
        return vuelo_codigo;
    }

    public void setVuelo_codigo(String vuelo_codigo) {
        this.vuelo_codigo = vuelo_codigo;
    }

    public String getVuelo_avion() {
        return vuelo_avion;
    }

    public void setVuelo_avion(String vuelo_avion) {
        this.vuelo_avion = vuelo_avion;
    }

    public int getVuelo_capacidad() {
        return vuelo_capacidad;
    }

    public void setVuelo_capacidad(int vuelo_capacidad) {
        this.vuelo_capacidad = vuelo_capacidad;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.vuelo_id;
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
        final Vuelo other = (Vuelo) obj;
        if (this.vuelo_id != other.vuelo_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "vuelo_id=" + vuelo_id + '}';
    }
    
    
    
}
