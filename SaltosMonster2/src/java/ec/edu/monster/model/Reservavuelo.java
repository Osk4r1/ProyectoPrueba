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
@Table(name = "reservavuelo")
public class Reservavuelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codReserva;

    @Column(name = "numVuelo")
    private Integer numVuelo;

    @Temporal(TemporalType.DATE)
    @Column(name = "horarioVuelo")
    private Date horarioVuelo;

    @Column(name = "pasajero")
    private String pasajero;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "equipo")
    private Double equipo;

    @Column(name = "camarografo")
    private Double camarografo;

    @Column(name = "totalcliente")
    private Double totalcliente;

    @Column(name = "total")
    private Double total;

    public int getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(int codReserva) {
        this.codReserva = codReserva;
    }

    public Integer getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(Integer numVuelo) {
        this.numVuelo = numVuelo;
    }

    public Date getHorarioVuelo() {
        return horarioVuelo;
    }

    public void setHorarioVuelo(Date horarioVuelo) {
        this.horarioVuelo = horarioVuelo;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getEquipo() {
        return equipo;
    }

    public void setEquipo(Double equipo) {
        this.equipo = equipo;
    }

    public Double getCamarografo() {
        return camarografo;
    }

    public void setCamarografo(Double camarografo) {
        this.camarografo = camarografo;
    }

    public Double getTotalcliente() {
        return totalcliente;
    }

    public void setTotalcliente(Double totalcliente) {
        this.totalcliente = totalcliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codReserva;
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
        final Reservavuelo other = (Reservavuelo) obj;
        if (this.codReserva != other.codReserva) {
            return false;
        }
        return true;
    }

}
