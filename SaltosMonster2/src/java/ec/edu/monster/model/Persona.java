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
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int persona_id;

    @Column(name = "PERSONA_NOMBRES")
    private String persona_nombres;

    @Column(name = "PERSONA_APELLIDOS")
    private String persona_apellidos;

    @Column(name = "PERSONA_CEDULA")
    private String persona_cedula;

    @Column(name = "PERSONA_FOTO")
    private String persona_foto;

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }

    public String getPersona_nombres() {
        return persona_nombres;
    }

    public void setPersona_nombres(String persona_nombres) {
        this.persona_nombres = persona_nombres;
    }

    public String getPersona_apellidos() {
        return persona_apellidos;
    }

    public void setPersona_apellidos(String persona_apellidos) {
        this.persona_apellidos = persona_apellidos;
    }

    public String getPersona_cedula() {
        return persona_cedula;
    }

    public void setPersona_cedula(String persona_cedula) {
        this.persona_cedula = persona_cedula;
    }

    public String getPersona_foto() {
        return persona_foto;
    }

    public void setPersona_foto(String persona_foto) {
        this.persona_foto = persona_foto;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.persona_id;
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
        final Persona other = (Persona) obj;
        if (this.persona_id != other.persona_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %s",persona_nombres, persona_apellidos);
    }

}
