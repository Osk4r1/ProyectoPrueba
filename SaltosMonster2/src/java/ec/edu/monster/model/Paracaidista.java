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
@Table (name = "paracaidista")
public class Paracaidista implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paracaidista_id;
    
    @Column(name = "PERSONA_ID")
    private int persona_id;
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;
    
    @Column(name = "PARACAIDISTA_TIPO")
    private String paracaidista_tipo;
    
    @Column(name = "PARACAIDISTA_ESCUELA")
    private String paracaidista_escuela;
    
    @Column(name = "PARACAIDISTA_NUMSALTOS")
    private int paracaidista_numsaltos;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "PARACAIDISTA_FECHASALTO")
    private Date paracaidista_fechasalto;
    
    @Column(name = "PARACAIDISTA_FOTO")
    private String paracaidista_foto;

    public int getParacaidista_id() {
        return paracaidista_id;
    }

    public void setParacaidista_id(int paracaidista_id) {
        this.paracaidista_id = paracaidista_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getParacaidista_tipo() {
        return paracaidista_tipo;
    }

    public void setParacaidista_tipo(String paracaidista_tipo) {
        this.paracaidista_tipo = paracaidista_tipo;
    }

    public String getParacaidista_escuela() {
        return paracaidista_escuela;
    }

    public void setParacaidista_escuela(String paracaidista_escuela) {
        this.paracaidista_escuela = paracaidista_escuela;
    }

    public int getParacaidista_numsaltos() {
        return paracaidista_numsaltos;
    }

    public void setParacaidista_numsaltos(int paracaidista_numsaltos) {
        this.paracaidista_numsaltos = paracaidista_numsaltos;
    }

    public Date getParacaidista_fechasalto() {
        return paracaidista_fechasalto;
    }

    public void setParacaidista_fechasalto(Date paracaidista_fechasalto) {
        this.paracaidista_fechasalto = paracaidista_fechasalto;
    }

    public String getParacaidista_foto() {
        return paracaidista_foto;
    }

    public void setParacaidista_foto(String paracaidista_foto) {
        this.paracaidista_foto = paracaidista_foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.paracaidista_id;
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
        final Paracaidista other = (Paracaidista) obj;
        if (this.paracaidista_id != other.paracaidista_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paracaidista{" + "paracaidista_id=" + paracaidista_id + '}';
    }
    
    
    
    
}
