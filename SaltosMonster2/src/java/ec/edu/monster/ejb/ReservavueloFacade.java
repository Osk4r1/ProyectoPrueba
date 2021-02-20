/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Reservavuelo;
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
public class ReservavueloFacade extends AbstractFacade<Reservavuelo> implements ReservavueloFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservavueloFacade() {
        super(Reservavuelo.class);
    }

    @Override
    public List<Reservavuelo> listarReservas(int numVuelo) {

        List<Reservavuelo> lista = null;
        String consulta;
        try {
            consulta = "SELECT r FROM Reservavuelo r WHERE r.numVuelo = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, numVuelo);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

    @Override
    public Double sumaTotal(int numVuelo) {

        Reservavuelo reservaVuelo = null;
        String consulta;
        Double total = 0.0;
        try {

            //consulta="SELECT c FROM Cliente c"+idPersona;
            consulta = "SELECT r FROM Reservavuelo r WHERE r.numVuelo = ?1";
            //"       select c from Course c inner join c.users us where us.username=:usr"
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, numVuelo);

            List<Reservavuelo> lista = query.getResultList();

            if (!lista.isEmpty()) {
                reservaVuelo = lista.get(0);
                total = reservaVuelo.getTotal();
            }

        } catch (Exception e) {
            throw e;
        }
        return total;

    }

    public void updateTotal(int numVuelo, Double total) {
        String consulta;
        try {
            consulta = "UPDATE Reservavuelo r set r.total = ?1 WHERE r.numVuelo = ?2";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, total);
            query.setParameter(2, numVuelo);
            query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Reservavuelo> listarLibres() {

        List<Reservavuelo> lista = null;
        String consulta;
        try {
            consulta = "SELECT r FROM Reservavuelo r WHERE r.tipo=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "libre cliente");
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

    @Override
    public List<Reservavuelo> listarTandem() {

        List<Reservavuelo> lista = null;
        String consulta;
        try {
            consulta = "SELECT r FROM Reservavuelo r WHERE r.tipo=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, "tándem cliente");
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

}
