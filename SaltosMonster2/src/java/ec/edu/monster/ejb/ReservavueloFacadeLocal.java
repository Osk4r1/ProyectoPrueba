/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Reservavuelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface ReservavueloFacadeLocal {

    void create(Reservavuelo reservavuelo);

    void edit(Reservavuelo reservavuelo);

    void remove(Reservavuelo reservavuelo);

    Reservavuelo find(Object id);

    List<Reservavuelo> findAll();

    List<Reservavuelo> findRange(int[] range);

    int count();

    List<Reservavuelo> listarReservas(int numVuelo);

    Double sumaTotal(int numVuelo);

    void updateTotal(int numVuelo, Double total);
    
    List<Reservavuelo> listarLibres();
    
    List<Reservavuelo> listarTandem();

}
