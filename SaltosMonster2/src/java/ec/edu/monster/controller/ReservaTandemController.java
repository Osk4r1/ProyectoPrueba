/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.AdicionalFacadeLocal;
import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.HorarioFacadeLocal;
import ec.edu.monster.ejb.LibreFacadeLocal;
import ec.edu.monster.ejb.ParacaidistaFacadeLocal;
import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.ejb.ReservaFacadeLocal;
import ec.edu.monster.ejb.TandemFacadeLocal;
import ec.edu.monster.ejb.TarifaFacadeLocal;
import ec.edu.monster.ejb.VueloFacadeLocal;
import ec.edu.monster.model.Adicional;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Horario;
import ec.edu.monster.model.Libre;
import ec.edu.monster.model.Paracaidista;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Reserva;
import ec.edu.monster.model.Tandem;
import ec.edu.monster.model.Tarifa;
import ec.edu.monster.model.Usuario;
import ec.edu.monster.model.Vuelo;
import java.io.Serializable;
import java.util.List;
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
public class ReservaTandemController implements Serializable {

    @EJB
    private VueloFacadeLocal vueloEJB;

    @EJB
    private HorarioFacadeLocal horarioEJB;

    @EJB
    private TandemFacadeLocal tandemEJB;

    @EJB
    private ReservaFacadeLocal reservaEJB;

    @EJB
    private TarifaFacadeLocal tarifaEJB;

    @EJB
    private AdicionalFacadeLocal adicionalEJB;

    @EJB
    private PersonaFacadeLocal personaEJB;
    private Persona persona;

    @EJB
    private ClienteFacadeLocal clienteEJB;
    private Cliente cliente;

    private List<Horario> horarios;
    private int selectedItemIndex;
    private Horario horario;
    private Vuelo vuelo;
    private Tarifa tarifa;
    private boolean adicionalCamara;
    private boolean adicionalEquipo;

    private Adicional adicional;
    private Reserva reserva;

    private Tandem tandem;

    private Usuario us;

    @PostConstruct
    public void init() {

        horarios = horarioEJB.findAll();
        tarifa = new Tarifa();
        tandem = new Tandem();
        adicional = new Adicional();
        persona = new Persona();
        cliente = new Cliente();
        vuelo = new Vuelo();
        reserva = new Reserva();
        us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isAdicionalCamara() {
        return adicionalCamara;
    }

    public void setAdicionalCamara(boolean adicionalCamara) {
        this.adicionalCamara = adicionalCamara;
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

    public Adicional getAdicional() {
        return adicional;
    }

    public void setAdicional(Adicional adicional) {
        this.adicional = adicional;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void recuperarVuelo() {
        vuelo = vueloEJB.encontrarVuelo(horario.getHorario_id());
        tarifa.setTarifa_costo(308.00);
    }

    public void leer(Horario horarioSeleccionar) {
        horario = horarioSeleccionar;
        recuperarVuelo();

    }

    public void recuperarCliente() {

        try {
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }

    }

    public void recuperarPersona() {

        persona = personaEJB.find(us.getPersona());
        /*us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            System.out.println(us.getPersona());
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }*/

    }

    public void registrar() {
        System.out.println("RECUPERAR PARACAIDISTA" + us.getUsuario_nombre());

        recuperarPersona();
        recuperarCliente();
        this.tandem.setPersona_id(persona.getPersona_id());
        this.tandem.setCliente_id(cliente.getCliente_id());
        this.tandem.setVuelo_id(vuelo.getVuelo_id());
        System.out.println("PARACAIDISTA" + tandem.getCliente_id());
        this.tandem.setTandem_descripcion("Tandem");

        tandemEJB.create(tandem);

        tarifaEJB.create(tarifa);

        this.reserva.setCliente_id(cliente.getCliente_id());
        this.reserva.setVuelo_id(vuelo.getVuelo_id());
        this.reserva.setTarifa_id(tarifa.getTarifa_id());
        reservaEJB.create(reserva);

        //CUPULA
        if (adicionalCamara) {
            this.adicional.setTarifa_id(tarifa.getTarifa_id());
            this.adicional.setCamarografo_id(70.00);
            this.adicional.setEquipo_id(0.00);
            adicionalEJB.create(adicional);
        } else {
            this.adicional.setTarifa_id(tarifa.getTarifa_id());
            this.adicional.setCamarografo_id(0.00);
            this.adicional.setEquipo_id(0.00);
            adicionalEJB.create(adicional);
        }
    }

    /*READ RESERVA*/
    public void recuperarReserva() {
        recuperarCliente();

    }
}
