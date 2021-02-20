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
@Table(name = "modulotree")
public class Modulotree implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mod_codigo;

    @Column(name = "rol_id")
    private int rol_id;

    @Column(name = "subsistema_id")
    private int subsistema_id;

    @Column(name = "opcion_id")
    private int opcion_id;

    public int getMod_codigo() {
        return mod_codigo;
    }

    public void setMod_codigo(int mod_codigo) {
        this.mod_codigo = mod_codigo;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getSubsistema_id() {
        return subsistema_id;
    }

    public void setSubsistema_id(int subsistema_id) {
        this.subsistema_id = subsistema_id;
    }

    public int getOpcion_id() {
        return opcion_id;
    }

    public void setOpcion_id(int opcion_id) {
        this.opcion_id = opcion_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.mod_codigo;
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
        final Modulotree other = (Modulotree) obj;
        if (this.mod_codigo != other.mod_codigo) {
            return false;
        }
        return true;
    }
    
    
    
}
