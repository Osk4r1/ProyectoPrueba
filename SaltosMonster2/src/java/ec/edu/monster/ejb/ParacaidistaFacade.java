/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Paracaidista;
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
public class ParacaidistaFacade extends AbstractFacade<Paracaidista> implements ParacaidistaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParacaidistaFacade() {
        super(Paracaidista.class);
    }

    @Override
    public Paracaidista encontrarParacaidista(int idCliente) {
        //System.out.println("AQUI HAY ALGO EN ENCONTRAR "+idPersona);
        Paracaidista paracaidista=null;
        String consulta;
        try{
            
            //consulta="SELECT c FROM Cliente c"+idPersona;
            consulta="SELECT p FROM Paracaidista p WHERE p.cliente_id = ?1";
            //"       select c from Course c inner join c.users us where us.username=:usr"
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query= em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idCliente);
            
            List<Paracaidista> lista=query.getResultList();
            
            if(!lista.isEmpty()){
                paracaidista=lista.get(0);
                
                
                
            }
            
        }catch(Exception e){
            throw e;
        }
        return paracaidista;    
    }
    
}
