/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Vuelosalto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface VuelosaltoFacadeLocal {

    void create(Vuelosalto vuelosalto);

    void edit(Vuelosalto vuelosalto);

    void remove(Vuelosalto vuelosalto);

    Vuelosalto find(Object id);

    List<Vuelosalto> findAll();

    List<Vuelosalto> findRange(int[] range);

    int count();
    
}
