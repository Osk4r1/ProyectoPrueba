/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author danie
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SaltosMonsterPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario iniciarSesion(Usuario us) {

        Usuario usuario = null;
        String encriptado = DigestUtils.md5Hex(us.getUsuario_password());
        String consulta;
        try {
            consulta = "SELECT u FROM Usuario u WHERE u.usuario_nombre = ?1 and u.usuario_password = ?2";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, us.getUsuario_nombre());
            query.setParameter(2, us.getUsuario_password());

            List<Usuario> lista = query.getResultList();

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }

    @Override
    public List<Usuario> usuarioRol(Integer idrol) throws Exception {
        List<Usuario> lista = null;
        String consulta;
        try {
            consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and r.rol_id=?1";
            //consulta = "SELECT u FROM Usuario u WHERE u.rol=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idrol);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public List<Usuario> usuarioNoRol(Integer idrol) throws Exception {

        List<Usuario> lista = null;
        String consulta;
        try {
            System.out.println("NO ROL" + idrol);
            //consulta = "SELECT h FROM Horario h, Vuelo v, Reserva r WHERE h.horario_id=v.horario_id and v.vuelo_id = r.vuelo_id and r.cliente_id=?1";
            consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and r.rol_id!=?1 GROUP BY u.usuario_nombre";
            //consulta = "SELECT u FROM Usuario u WHERE u.rol!=?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, idrol);
            //Query query= em.createNativeQuery(consulta);

            lista = query.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

    @Override
    public Usuario usuarioObjeto(String nombreUsuario) throws Exception {

        Usuario usuario = null;

        String consulta;
        try {
            //consulta = "SELECT u FROM Usuario u, Usurol r WHERE u.usuario_id=r.usuario_id and u.usuario_nombre=?1";
            consulta = "SELECT u FROM Usuario u WHERE u.usuario_nombre = ?1 ";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, nombreUsuario);

            List<Usuario> lista = query.getResultList();

            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return usuario;

    }

    @Override
    public void actualizarTodos(Integer idrol) throws Exception {

        String consulta;
        try {
            consulta = "UPDATE Usuario u set u.rol = ?1";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idrol);
            query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminarUno(Integer idrol, Integer idusuario) {
        String consulta;
        try {
            consulta = "DELETE FROM Usurol r WHERE r.rol_id=?1 AND r.usuario_id=?2";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, idrol);
            query.setParameter(2, idusuario);
            query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void actualizarContra(Usuario us) throws Exception {
        String consulta;
        
        try {
            consulta = "UPDATE Usuario u set u.usuario_password=?1, u.estado=1 WHERE u.usuario_nombre = ?2";
            //consulta="SELECT * FROM Usuario u WHERE u.USUARIO_NOMBRE = ?1 and u.USUARIO_PASSWORD = ?2";
            Query query = em.createQuery(consulta);
            //Query query= em.createNativeQuery(consulta);
            query.setParameter(1, us.getUsuario_password());
            query.setParameter(2, us.getUsuario_nombre());
            query.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }
}
