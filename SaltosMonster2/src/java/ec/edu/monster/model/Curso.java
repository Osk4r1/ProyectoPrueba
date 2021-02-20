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
@Table(name = "curso")
public class Curso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int curso_id;
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;
    
    @Column(name = "PARACAIDISTA_ID")
    private int paracaidista_id;
    
    @Column(name = "CURSO_TIPO")
    private String curso_tipo;
    
    @Column(name = "CURSO_LUGAR")
    private String curso_lugar;

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getParacaidista_id() {
        return paracaidista_id;
    }

    public void setParacaidista_id(int paracaidista_id) {
        this.paracaidista_id = paracaidista_id;
    }

    public String getCurso_tipo() {
        return curso_tipo;
    }

    public void setCurso_tipo(String curso_tipo) {
        this.curso_tipo = curso_tipo;
    }

    public String getCurso_lugar() {
        return curso_lugar;
    }

    public void setCurso_lugar(String curso_lugar) {
        this.curso_lugar = curso_lugar;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.curso_id;
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
        final Curso other = (Curso) obj;
        if (this.curso_id != other.curso_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Curso{" + "curso_id=" + curso_id + '}';
    }
    
    
    
    
}
