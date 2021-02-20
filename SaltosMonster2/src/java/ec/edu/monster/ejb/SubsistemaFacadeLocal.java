/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Subsistema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface SubsistemaFacadeLocal {

    void create(Subsistema subsistema);

    void edit(Subsistema subsistema);

    void remove(Subsistema subsistema);

    Subsistema find(Object id);

    List<Subsistema> findAll();

    List<Subsistema> findRange(int[] range);

    int count();
    
    List<Subsistema> listarSubsistemas();
    
    List<Subsistema> listarSubsistemas(int rol_id);    
    
    List<Subsistema> listarNoSubsistemas(int rol_id);    
    
    Subsistema subsistemaObjeto(String nombreSubsistema) throws Exception;
}
