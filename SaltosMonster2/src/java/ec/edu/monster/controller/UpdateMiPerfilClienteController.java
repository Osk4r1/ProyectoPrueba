/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author danie
 */

@Named
@SessionScoped
public class UpdateMiPerfilClienteController implements Serializable{
    
    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;
    
    @EJB
    private ClienteFacadeLocal clienteEJB;
    private Cliente cliente;
    
    private Usuario us;
    
    @PostConstruct
    public void init(){
        persona = new Persona();
        cliente = new Cliente();
        this.recuperarCliente();
        this.recuperarPersona();
        
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void recuperarCliente() {
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            //System.out.println("RECUPERAR CLIENTE EN READ "+us.getPersona());
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }

    }    
    
    public void recuperarPersona() {
       
        //System.out.println("RECUPERAR PERSONA EN READ "+us.getPersona());
        persona=personaEJB.find(us.getPersona());
        /*us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            System.out.println(us.getPersona());
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }*/

    }
    
    public void modificar(){
        personaEJB.edit(persona);
        clienteEJB.edit(cliente);
    }
}
