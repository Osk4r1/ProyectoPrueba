/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Libre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface LibreFacadeLocal {

    void create(Libre libre);

    void edit(Libre libre);

    void remove(Libre libre);

    Libre find(Object id);

    List<Libre> findAll();

    List<Libre> findRange(int[] range);

    int count();
    
}
