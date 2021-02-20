/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Tarifa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author danie
 */
@Stateless
public class TarifaFacade extends AbstractFacade<Tarifa> implements TarifaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TarifaFacade() {
        super(Tarifa.class);
    }

    @Override
    public Tarifa recuperarTarifa(int idVuelo, int idCliente) {
        
        Tarifa tarifa=null;
        String consulta;
        try{
            consulta="SELECT t FROM Tarifa t, Reserva r WHERE t.tarifa_id = r.tarifa_id and r.vuelo_id = ?1 and r.cliente_id=?2";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query= em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idVuelo);
            query.setParameter(2, idCliente);
            
            List<Tarifa> lista=query.getResultList();
            
            if(!lista.isEmpty()){
                tarifa=lista.get(0);
            }
            
        }catch(Exception e){
            throw e;
        }
        return tarifa;}
    
}
