/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Opcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface OpcionFacadeLocal {

    void create(Opcion opcion);

    void edit(Opcion opcion);

    void remove(Opcion opcion);

    Opcion find(Object id);

    List<Opcion> findAll();

    List<Opcion> findRange(int[] range);

    int count();

    List<Opcion> listarOpciones();

    List<Opcion> listarSubsistemas(int rol_id);

    List<Opcion> listarNoSubsistemas(int rol_id);
}
