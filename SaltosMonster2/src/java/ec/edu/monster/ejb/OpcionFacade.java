/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Opcion;
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
public class OpcionFacade extends AbstractFacade<Opcion> implements OpcionFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OpcionFacade() {
        super(Opcion.class);
    }

    @Override
    public List<Opcion> listarOpciones() {
        List<Opcion> lista = null;
        String consulta;
        try {
            consulta = "SELECT o FROM Opcion o";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public List<Opcion> listarSubsistemas(int rol_id) {

        List<Opcion> lista = null;
        String consulta;
        try {
            //consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and r.rol_id=?1";
            consulta = "SELECT o FROM Opcion o, Subsistema s, Modulotree m WHERE o.opcion_id=m.opcion_id and s.subsistema_id=m.subsistema_id and m.rol_id=?1";
            //consulta = "SELECT s FROM Subsistema s WHERE s.rol_id = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, rol_id);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public List<Opcion> listarNoSubsistemas(int rol_id) {

        List<Opcion> lista = null;
        String consulta;
        try {
            //consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and r.rol_id=?1";
            consulta = "SELECT o FROM Opcion o, Subsistema s, Modulotree m WHERE o.opcion_id=m.opcion_id and s.subsistema_id=m.subsistema_id and m.rol_id!=?1";
            //consulta = "SELECT s FROM Subsistema s WHERE s.rol_id = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, rol_id);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
