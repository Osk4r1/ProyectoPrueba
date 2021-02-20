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
@Table(name = "vuelosalto")
public class Vuelosalto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salto_id;

    @Column(name = "vuelo_avion")
    private String vuelo_avion;

    @Column(name = "vuelo_tandem")
    private int vuelo_tandem;

    @Column(name = "vuelo_libre")
    private int vuelo_libre;

    @Temporal(TemporalType.DATE)
    @Column(name = "horario_fecha")
    private Date horario_fecha;

    //@Temporal(TemporalType.TIME)
    @Column(name = "horario_hora")
    private String horario_hora;

    @Column(name = "disponible")
    private Integer disponible;

    public int getSalto_id() {
        return salto_id;
    }

    public void setSalto_id(int salto_id) {
        this.salto_id = salto_id;
    }

    public String getVuelo_avion() {
        return vuelo_avion;
    }

    public void setVuelo_avion(String vuelo_avion) {
        this.vuelo_avion = vuelo_avion;
    }

    public int getVuelo_tandem() {
        return vuelo_tandem;
    }

    public void setVuelo_tandem(int vuelo_tandem) {
        this.vuelo_tandem = vuelo_tandem;
    }

    public int getVuelo_libre() {
        return vuelo_libre;
    }

    public void setVuelo_libre(int vuelo_libre) {
        this.vuelo_libre = vuelo_libre;
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

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.salto_id;
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
        final Vuelosalto other = (Vuelosalto) obj;
        if (this.salto_id != other.salto_id) {
            return false;
        }
        return true;
    }

}
