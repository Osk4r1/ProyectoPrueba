/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Adicional;
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
public class AdicionalFacade extends AbstractFacade<Adicional> implements AdicionalFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdicionalFacade() {
        super(Adicional.class);
    }

    @Override
    public Adicional recuperarAdicional(int idTarifa) {
        Adicional adicional = null;
        String consulta;
        try {
            consulta = "SELECT a FROM Adicional a WHERE a.tarifa_id = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idTarifa);

            List<Adicional> lista = query.getResultList();

            if (!lista.isEmpty()) {
                adicional = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return adicional;
    }
}
