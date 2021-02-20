package ec.edu.monster.controller;

import ec.edu.monster.ejb.AdicionalFacadeLocal;
import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.HorarioFacadeLocal;
import ec.edu.monster.ejb.LibreFacadeLocal;
import ec.edu.monster.ejb.ParacaidistaFacadeLocal;
import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.ejb.ReservaFacadeLocal;
import ec.edu.monster.ejb.TarifaFacadeLocal;
import ec.edu.monster.ejb.VueloFacadeLocal;
import ec.edu.monster.model.Adicional;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Horario;
import ec.edu.monster.model.Libre;
import ec.edu.monster.model.Paracaidista;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Reserva;
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
public class ReservaLibreController implements Serializable {

    @EJB
    private VueloFacadeLocal vueloEJB;

    @EJB
    private HorarioFacadeLocal horarioEJB;

    @EJB
    private LibreFacadeLocal libreEJB;

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

    @EJB
    private ParacaidistaFacadeLocal paracaidistaEJB;
    private Paracaidista paracaidista;

    private List<Horario> horarios;
    private int selectedItemIndex;
    private Horario horario;
    private Vuelo vuelo;
    private Tarifa tarifa;
    private boolean adicionalCamara;
    private Adicional adicional;
    private Reserva reserva;

    private Libre libre;

    private Usuario us;

    @PostConstruct
    public void init() {

        horarios = horarioEJB.findAll();
        tarifa = new Tarifa();
        libre = new Libre();
        adicional = new Adicional();
        persona = new Persona();
        cliente = new Cliente();
        paracaidista = new Paracaidista();
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

    public Paracaidista getParacaidista() {
        return paracaidista;
    }

    public void setParacaidista(Paracaidista paracaidista) {
        this.paracaidista = paracaidista;
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

    public Libre getLibre() {
        return libre;
    }

    public void setLibre(Libre libre) {
        this.libre = libre;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public void recuperarVuelo() {
        vuelo = vueloEJB.encontrarVuelo(horario.getHorario_id());

        if (vuelo.getVuelo_capacidad() == 2) {
            tarifa.setTarifa_costo(40.00);
        }
        if (vuelo.getVuelo_capacidad() == 1) {
            tarifa.setTarifa_costo(50.00);
        }
        if (vuelo.getVuelo_capacidad() == 0) {
            tarifa.setTarifa_costo(60.00);
        }
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

    public void recuperarParacaidista() {
        paracaidista = paracaidistaEJB.encontrarParacaidista(cliente.getCliente_id());
    }

    public void registrar() {
        System.out.println("RECUPERAR PARACAIDISTA" + us.getUsuario_nombre());

        recuperarPersona();
        recuperarCliente();
        recuperarParacaidista();;

        try {
            this.libre.setCliente_id(cliente.getCliente_id());
            this.libre.setParacaidista_id(paracaidista.getParacaidista_id());
            this.libre.setVuelo_id(vuelo.getVuelo_id());
            this.libre.setLibre("Libre");

            System.out.println("RECUPERAR PARACAIDISTA" + libre.getLibre());
            libreEJB.create(libre);

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

        } catch (Exception e) {
        }
    }

    /*READ RESERVA*/
    public void recuperarReserva() {
        recuperarCliente();

    }

}
