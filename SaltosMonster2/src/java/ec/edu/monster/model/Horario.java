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
@Table (name = "horario")
public class Horario implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int horario_id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "HORARIO_FECHA")    
    private Date horario_fecha;

    //@Temporal(TemporalType.TIME)
    @Column(name = "HORARIO_HORA")     
    private String horario_hora;

    public int getHorario_id() {
        return horario_id;
    }

    public void setHorario_id(int horario_id) {
        this.horario_id = horario_id;
    }

    public Date getHorario_fecha() {
        return horario_fecha;
    }

    public void setHorario_fecha(Date horario_fecha) {
        this.horario_fecha = horario_fecha;
    }

    public String getHorario_hora() {
        return horario_hora;
    }

    public void setHorario_hora(String horario_hora) {
        this.horario_hora = horario_hora;
    }



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.horario_id;
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
        final Horario other = (Horario) obj;
        if (this.horario_id != other.horario_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "horario_id=" + horario_id + '}';
    }
    
    
    
}
