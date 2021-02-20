/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Modulotree;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface ModulotreeFacadeLocal {

    void create(Modulotree modulotree);

    void edit(Modulotree modulotree);

    void remove(Modulotree modulotree);

    Modulotree find(Object id);

    List<Modulotree> findAll();

    List<Modulotree> findRange(int[] range);

    int count();
    
}
