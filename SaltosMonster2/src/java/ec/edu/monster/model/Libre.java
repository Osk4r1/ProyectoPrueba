
package ec.edu.monster.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="libre")
public class Libre implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int libre_id;
    
    
    @Column(name = "CLIENTE_ID")
    private int cliente_id;
    
    @Column(name = "PARACAIDISTA_ID")
    private int paracaidista_id;
    
    @Column(name = "VUELO_ID")
    private int vuelo_id;
    
    @Column(name = "LIBRE_DESCRIPCION")
    private String libre;

    public int getLibre_id() {
        return libre_id;
    }

    public void setLibre_id(int libre_id) {
        this.libre_id = libre_id;
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

    public int getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(int vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public String getLibre() {
        return libre;
    }

    public void setLibre(String libre) {
        this.libre = libre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.libre_id;
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
        final Libre other = (Libre) obj;
        if (this.libre_id != other.libre_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Libre{" + "libre_id=" + libre_id + '}';
    }
    
    
    
    
}
