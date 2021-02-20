/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Adicional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface AdicionalFacadeLocal {

    void create(Adicional adicional);

    void edit(Adicional adicional);

    void remove(Adicional adicional);

    Adicional find(Object id);

    List<Adicional> findAll();

    List<Adicional> findRange(int[] range);

    int count();

    Adicional recuperarAdicional(int idTarifa);
}
