/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Rol;
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
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public Rol getRolId(String descripRol) throws Exception {

        Rol rol = null;
        String consulta;
        try {
            consulta = "SELECT r FROM Rol r WHERE r.rol_descripcion = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, descripRol);


            List<Rol> lista = query.getResultList();

            if (!lista.isEmpty()) {
                rol = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return rol;

    }

}
