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
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class GestionarClienteAController implements Serializable {

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
    private List<Cliente> clientes;
    private List<Usuario> usuarios;
    private int selectedItemIndex;

    private Usuario us;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        persona = new Persona();
        rol = new Rol();
        cliente = new Cliente();

        personas = personaEJB.findAll();
        clientes = clienteEJB.findAll();
        usuarios = usuarioEJB.findAll();

    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void registrar() {
        try {

            this.cliente.setPersona(persona);
            clienteEJB.create(cliente);

            this.usuario.setPersona(persona.getPersona_id());
            this.usuario.setRol(1);

            usuarioEJB.create(usuario);
        } catch (Exception e) {
        }
    }
    
    public Persona getSelected() {
        if (persona == null) {
            persona = new Persona();
            selectedItemIndex = -1;
        }
        return persona;
    }

    public Cliente getSelectedC() {
        if (cliente == null) {
            cliente = new Cliente();
            selectedItemIndex = -1;
        }
        return cliente;
    }    

    public void recuperarCliente() {
        //us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            //System.out.println("RECUPERAR CLIENTE EN READ " + us.getPersona());
            
            cliente = clienteEJB.encontrarPersona(usuario.getPersona());
            //System.out.println("RECUPERAR CLIENTE"+ cliente.getCliente_correo());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }

    }

    public void update() {
        //System.out.println("UPDATE " + usuario.getUsuario_nombre());
        
        //System.out.println("PERSONA " + persona.getPersona_nombres());
        
        //System.out.println("CLIENTE " + cliente.getCliente_correo());
        
        try {
            personaEJB.edit(persona);
            clienteEJB.edit(cliente);
        } catch (Exception e) {

        }
    }

    public void recuperarPersona() {

        //System.out.println("RECUPERAR PERSONA EN READ " + us.getPersona());
        persona = personaEJB.find(usuario.getPersona());
        //System.out.println("RECUPERAR PERSONA"+ persona.getPersona_nombres());
        /*us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            System.out.println(us.getPersona());
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }*/

    }

    public void leer(Usuario usuarioSeleccion) {
        //System.out.println("LEER SELECCION" + rolSeleccion.getRol_descripcion());
        usuario = usuarioSeleccion;
        recuperarCliente();
        recuperarPersona();
        //System.out.println("LEER DE ROL" + rol.getRol_descripcion());
        //subsistemas = subsistemaEJB.listarSubsistemas(rol.getRol_id());
        //subsistemasNo = subsistemaEJB.listarNoSubsistemas(rol.getRol_id());
    }

}
