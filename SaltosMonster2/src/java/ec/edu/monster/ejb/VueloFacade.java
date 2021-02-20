/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Vuelo;
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
public class VueloFacade extends AbstractFacade<Vuelo> implements VueloFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VueloFacade() {
        super(Vuelo.class);
    }
    
    @Override
    public Vuelo encontrarVuelo(int idHorario) {
        
        //System.out.println("AQUI HAY ALGO EN ENCONTRAR "+idPersona);
        Vuelo vuelo=null;
        String consulta;
        try{
            
            //consulta="SELECT c FROM Cliente c"+idPersona;
            consulta="SELECT v FROM Vuelo v WHERE v.horario_id = ?1";
            //"       select c from Course c inner join c.users us where us.username=:usr"
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query= em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idHorario);
            
            List<Vuelo> lista=query.getResultList();
            
            if(!lista.isEmpty()){
                vuelo=lista.get(0);
                
                
                
            }
            
        }catch(Exception e){
            throw e;
        }
        return vuelo;       
    }    
    
}
