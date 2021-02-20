/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Horario;
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
public class HorarioFacade extends AbstractFacade<Horario> implements HorarioFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }

    @Override
    public List<Horario> listarHorarios(int idVuelo) {

        Horario horario =null;
        List<Horario> lista = null;
        String consulta;
        try {
            consulta = "SELECT h FROM Horario h, Vuelo v, Reserva r WHERE h.horario_id=v.horario_id and v.vuelo_id = r.vuelo_id and r.cliente_id=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idVuelo);

            lista = query.getResultList();
            if (!lista.isEmpty()) {

                horario = lista.get(0);
                System.out.println(""+horario.getHorario_fecha());

            }

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
