/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Tandem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface TandemFacadeLocal {

    void create(Tandem tandem);

    void edit(Tandem tandem);

    void remove(Tandem tandem);

    Tandem find(Object id);

    List<Tandem> findAll();

    List<Tandem> findRange(int[] range);

    int count();
    
}
