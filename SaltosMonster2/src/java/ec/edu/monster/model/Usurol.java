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
@Table(name = "usurol")
public class Usurol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usucodigo;

    @Column(name = "rol_id")
    private int rol_id;

    @Column(name = "usuario_id")
    private int usuario_id;

    public int getUsucodigo() {
        return usucodigo;
    }

    public void setUsucodigo(int usucodigo) {
        this.usucodigo = usucodigo;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.usucodigo;
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
        final Usurol other = (Usurol) obj;
        if (this.usucodigo != other.usucodigo) {
            return false;
        }
        return true;
    }
    
    
}
