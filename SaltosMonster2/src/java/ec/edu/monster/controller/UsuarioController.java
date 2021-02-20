/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.ejb.UsuarioFacadeLocal;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Rol;
import ec.edu.monster.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    @EJB
    private ClienteFacadeLocal clienteEJB;

    @EJB
    private PersonaFacadeLocal personaEJB;

    private Persona persona;
    private Usuario usuario;
    private Cliente cliente;
    private Rol rol;

    private List<Persona> personas;
    private List<Usuario> usuarios;

    private Usuario us;

    //CONTRASENA
    private String contrasenia;

    private String actual;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        persona = new Persona();
        rol = new Rol();
        cliente = new Cliente();
        contrasenia = null;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String cambiar() {

        String redireccion = null;
        try {
            us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            String encriptado = contrasenia;
            us.setUsuario_password(encriptado);
            usuarioEJB.actualizarContra(us);
            redireccion = "/Vistas/Protegido/Principal?faces-redirect=true";
        } catch (Exception e) {
        }
        return redireccion;
    }

    public String actualizarContra() {
        String redireccion = null;
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        us.setUsuario_password(actual);
        Usuario usu;
        try {
            usu=usuarioEJB.iniciarSesion(us);
            if (usu != null) {
                String encriptado = contrasenia;
                us.setUsuario_password(encriptado);
                usuarioEJB.actualizarContra(us);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Aviso: Operación exitosa", "Operación exitosa"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Aviso: La contraseña es incorrecta", "La contraseña es incorrecta"));
            }
        } catch (Exception e) {
        }
        return redireccion;
    }

    public void registrar() {
        try {
            this.cliente.setPersona(persona);
            clienteEJB.create(cliente);
            this.usuario.setPersona(persona.getPersona_id());
            this.usuario.setRol(1);
            //String encriptado = DigestUtils.md5Hex(usuario.getUsuario_password());
            //usuario.setUsuario_password(encriptado);
            usuarioEJB.create(usuario);
        } catch (Exception e) {
        }
    }
}
