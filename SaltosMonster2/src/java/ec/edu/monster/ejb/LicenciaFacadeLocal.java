/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Licencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface LicenciaFacadeLocal {

    void create(Licencia licencia);

    void edit(Licencia licencia);

    void remove(Licencia licencia);

    Licencia find(Object id);

    List<Licencia> findAll();

    List<Licencia> findRange(int[] range);

    int count();
    
}
