/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Usurol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface UsurolFacadeLocal {

    void create(Usurol usurol);

    void edit(Usurol usurol);

    void remove(Usurol usurol);

    Usurol find(Object id);

    List<Usurol> findAll();

    List<Usurol> findRange(int[] range);

    int count();
    
}
