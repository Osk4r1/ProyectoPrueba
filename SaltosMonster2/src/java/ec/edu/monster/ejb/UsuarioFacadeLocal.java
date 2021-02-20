/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.ejb;

import ec.edu.monster.model.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author danie
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    Usuario iniciarSesion(Usuario us) throws Exception;
    
    List<Usuario> usuarioRol(Integer idrol) throws Exception;
    
    List<Usuario> usuarioNoRol(Integer idrol) throws Exception;
    
    Usuario usuarioObjeto(String nombreUsuario) throws Exception;
    
    void actualizarTodos(Integer idrol) throws Exception;
    
    void eliminarUno(Integer idrol, Integer idusuario);
    
    void actualizarContra(Usuario us) throws Exception;
}
