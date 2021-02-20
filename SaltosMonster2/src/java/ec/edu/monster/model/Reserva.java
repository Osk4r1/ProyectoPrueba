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
@Table (name="reserva")
public class Reserva implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private int reserva_id;
    
    @Column(name = "VUELO_ID")
    private int vuelo_id;
    
    @Column(name = "TARIFA_ID")
    private int tarifa_id;
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;    

    public int getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(int reserva_id) {
        this.reserva_id = reserva_id;
    }

    public int getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public int getTarifa_id() {
        return tarifa_id;
    }

    public void setTarifa_id(int tarifa_id) {
        this.tarifa_id = tarifa_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.reserva_id;
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
        final Reserva other = (Reserva) obj;
        if (this.reserva_id != other.reserva_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reserva{" + "reserva_id=" + reserva_id + '}';
    }
 
    
    
}
