/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Licencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author danie
 */
@Stateless
public class LicenciaFacade extends AbstractFacade<Licencia> implements LicenciaFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LicenciaFacade() {
        super(Licencia.class);
    }
    
}
