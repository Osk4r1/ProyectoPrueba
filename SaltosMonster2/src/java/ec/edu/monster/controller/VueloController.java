/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.HorarioFacadeLocal;
import ec.edu.monster.ejb.VueloFacadeLocal;
import ec.edu.monster.model.Horario;
import ec.edu.monster.model.Vuelo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author danie
 */

@Named
@SessionScoped
public class VueloController implements Serializable{
    
    @EJB
    private VueloFacadeLocal vueloEJB;
    
    @EJB
    private HorarioFacadeLocal horarioEJB;
    
    private Vuelo vuelo;
    private Horario horario;
    
    @PostConstruct
    public void init(){
        vuelo = new Vuelo();
        horario = new Horario();
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
    public void registrar(){
        try {
            horarioEJB.create(horario);
            
            vuelo.setHorario_id(horario.getHorario_id());
            vuelo.setVuelo_codigo("Vuelo "+horario.getHorario_id());
            vuelo.setVuelo_avion("Cesnna 206");
            vuelo.setVuelo_capacidad(2);
            vueloEJB.create(vuelo);
        } catch (Exception e) {
        }
    }
    
    
    
}
