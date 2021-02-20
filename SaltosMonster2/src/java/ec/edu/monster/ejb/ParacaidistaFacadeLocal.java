/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Paracaidista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface ParacaidistaFacadeLocal {

    void create(Paracaidista paracaidista);

    void edit(Paracaidista paracaidista);

    void remove(Paracaidista paracaidista);

    Paracaidista find(Object id);

    List<Paracaidista> findAll();

    List<Paracaidista> findRange(int[] range);

    int count();
    
    Paracaidista encontrarParacaidista(int idCliente);
    
}
