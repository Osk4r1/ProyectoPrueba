/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Reserva;
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
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservaFacade() {
        super(Reserva.class);
    }

    @Override
    public Reserva encontrarReserva(int idCliente) {
    
        //System.out.println("AQUI HAY ALGO EN ENCONTRAR "+idPersona);
        Reserva reserva=null;
        String consulta;
        try{
            
            //consulta="SELECT c FROM Cliente c"+idPersona;
            consulta="SELECT r FROM Reserva r WHERE r.cliente_id = ?1";
            //"       select c from Course c inner join c.users us where us.username=:usr"
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query= em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idCliente);
            
            List<Reserva> lista=query.getResultList();
            
            if(!lista.isEmpty()){
                reserva=lista.get(0);
                
                
                
            }
            
        }catch(Exception e){
            throw e;
        }
        return reserva;          
    
    
    }
    
}
