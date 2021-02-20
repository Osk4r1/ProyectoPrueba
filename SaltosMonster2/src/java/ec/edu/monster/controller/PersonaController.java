/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.model.Persona;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */

@Named
@ViewScoped
public class PersonaController implements Serializable{
    
    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
    @PostConstruct
    public void init(){
        persona = new Persona();
    }
    
    public void registrar(){
        try{
            personaEJB.create(persona);
        }
        catch(Exception e){}
        
    }
    
}
