/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Subsistema;
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
public class SubsistemaFacade extends AbstractFacade<Subsistema> implements SubsistemaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubsistemaFacade() {
        super(Subsistema.class);
    }

    @Override
    public List<Subsistema> listarSubsistemas() {
        List<Subsistema> lista = null;
        String consulta;
        try {
            consulta = "SELECT s FROM Subsistema s";
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
    public List<Subsistema> listarSubsistemas(int rol_id) {
        List<Subsistema> lista = null;
        String consulta;
        try {
            //consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and r.rol_id=?1";
            consulta = "SELECT s FROM Subsistema s, Modulotree m WHERE s.subsistema_id=m.subsistema_id and m.rol_id=?1";
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
    public List<Subsistema> listarNoSubsistemas(int rol_id) {
        List<Subsistema> lista = null;
        String consulta;
        try {
            consulta = "SELECT s FROM Subsistema s, Modulotree m WHERE s.subsistema_id=m.subsistema_id and m.rol_id!=?1";
            //consulta = "SELECT s FROM Subsistema s WHERE s.rol_id != ?1";
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
    public Subsistema subsistemaObjeto(String nombreSubsistema) throws Exception {

        Subsistema subsistema = null;

        String consulta;
        try {
            consulta = "SELECT s FROM Subsistema s WHERE s.subsistema_descripcion = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, nombreSubsistema);

            List<Subsistema> lista = query.getResultList();

            if (!lista.isEmpty()) {
                subsistema = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return subsistema;
    }

}
