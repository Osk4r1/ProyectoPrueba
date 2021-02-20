/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public List<Persona> listarPersonas(int idVuelo) {

        Persona persona = null;
        List<Persona> lista = null;
        String consulta;
        try {
            consulta = "SELECT p FROM Persona p, Cliente c, Reserva r, Vuelo v WHERE p.persona_id=c.persona_id and c.cliente_id=r.cliente_id and r.vuelo_id=v.vuelo_id and v.vuelo_id=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idVuelo);

            lista = query.getResultList();
            if (!lista.isEmpty()) {

                persona = lista.get(0);
                System.out.println("" + persona.getPersona_cedula());

            }

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

}
