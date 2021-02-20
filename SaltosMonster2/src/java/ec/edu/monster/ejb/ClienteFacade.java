/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente encontrarPersona(int idPersona) {
        
        //System.out.println("AQUI HAY ALGO EN ENCONTRAR "+idPersona);
        Cliente cliente=null;
        String consulta;
        try{
            
            //consulta="SELECT c FROM Cliente c"+idPersona;
            consulta="SELECT c FROM Cliente c left join c.persona p WHERE p.persona_id = ?1";
            //"       select c from Course c inner join c.users us where us.username=:usr"
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query= em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idPersona);
            
            List<Cliente> lista=query.getResultList();
            
            if(!lista.isEmpty()){
                cliente=lista.get(0);
                
                
                
            }
            
        }catch(Exception e){
            throw e;
        }
        return cliente;       
    }
    
}
