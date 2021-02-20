/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.PersonaFacadeLocal;
import ec.edu.monster.ejb.ReservavueloFacadeLocal;
import ec.edu.monster.ejb.VuelosaltoFacadeLocal;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Reservavuelo;
import ec.edu.monster.model.Vuelosalto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class VuelosaltoController implements Serializable {

    @EJB
    private VuelosaltoFacadeLocal vuelosaltoEJB;

    private Vuelosalto vuelosalto;
    private String numTandem;
    private String numLibre;
    private List<Vuelosalto> vuelos;

    private Vuelosalto vueloSelec;

    //********PASAJEROS
    @EJB
    private ReservavueloFacadeLocal reservavueloEJB;

    private Reservavuelo reservavuelo;
    private List<Reservavuelo> reservas;
    private Reservavuelo reservaRegistro;
    private List<Reservavuelo> reservaSelec;

    private String tipoSalto;
    private String tipoPasajero;

    @EJB
    private PersonaFacadeLocal personaEJB;

    private List<Persona> personas;

    private String nombreCliente;

    private Integer disponiblePas = 0;

    private String camara;

    private Double totalCliente = 0.0;
    private Double total = 0.0;

    private List<Reservavuelo> vuelosLibres;

    private List<Reservavuelo> vuelosTandem;

    @PostConstruct
    public void init() {
        vuelosalto = new Vuelosalto();
        vueloSelec = new Vuelosalto();
        vuelos = vuelosaltoEJB.findAll();

        reservavuelo = new Reservavuelo();
        reservas = reservavueloEJB.findAll();
        reservaRegistro = new Reservavuelo();

        personas = personaEJB.findAll();

        vuelosLibres = reservavueloEJB.listarLibres();
        vuelosTandem = reservavueloEJB.listarTandem();

    }

    public List<Vuelosalto> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelosalto> vuelos) {
        this.vuelos = vuelos;
    }

    public String getNumTandem() {
        return numTandem;
    }

    public void setNumTandem(String numTandem) {
        this.numTandem = numTandem;
    }

    public String getNumLibre() {
        return numLibre;
    }

    public void setNumLibre(String numLibre) {
        this.numLibre = numLibre;
    }

    public Vuelosalto getVuelosalto() {
        return vuelosalto;
    }

    public void setVuelosalto(Vuelosalto vuelosalto) {
        this.vuelosalto = vuelosalto;
    }

    public Vuelosalto getVueloSelec() {
        return vueloSelec;
    }

    public void setVueloSelec(Vuelosalto vueloSelec) {
        this.vueloSelec = vueloSelec;
    }

    public Reservavuelo getReservavuelo() {
        return reservavuelo;
    }

    public void setReservavuelo(Reservavuelo reservavuelo) {
        this.reservavuelo = reservavuelo;
    }

    public List<Reservavuelo> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservavuelo> reservas) {
        this.reservas = reservas;
    }

    public Reservavuelo getReservaRegistro() {
        return reservaRegistro;
    }

    public void setReservaRegistro(Reservavuelo reservaRegistro) {
        this.reservaRegistro = reservaRegistro;
    }

    public String getTipoSalto() {
        return tipoSalto;
    }

    public void setTipoSalto(String tipoSalto) {
        this.tipoSalto = tipoSalto;
    }

    public String getTipoPasajero() {
        return tipoPasajero;
    }

    public void setTipoPasajero(String tipoPasajero) {
        this.tipoPasajero = tipoPasajero;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getDisponiblePas() {
        return disponiblePas;
    }

    public void setDisponiblePas(Integer disponiblePas) {
        this.disponiblePas = disponiblePas;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public List<Reservavuelo> getReservaSelec() {
        return reservaSelec;
    }

    public void setReservaSelec(List<Reservavuelo> reservaSelec) {
        this.reservaSelec = reservaSelec;
    }

    public Double getTotalCliente() {
        return totalCliente;
    }

    public void setTotalCliente(Double totalCliente) {
        this.totalCliente = totalCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reservavuelo> getVuelosLibres() {
        return vuelosLibres;
    }

    public void setVuelosLibres(List<Reservavuelo> vuelosLibres) {
        this.vuelosLibres = vuelosLibres;
    }

    public List<Reservavuelo> getVuelosTandem() {
        return vuelosTandem;
    }

    public void setVuelosTandem(List<Reservavuelo> vuelosTandem) {
        this.vuelosTandem = vuelosTandem;
    }

    public void registrar() {
        try {

            if ((numTandem.equals("2") && numLibre.equals("1")) || (numTandem.equals("1") && numLibre.equals("3")) || (numTandem.equals("0") && numLibre.equals("5"))) {
                //System.out.println("permitido");

                vuelosalto.setVuelo_avion("Cesnna 206");
                vuelosalto.setVuelo_tandem(Integer.parseInt(numTandem));
                vuelosalto.setVuelo_libre(Integer.parseInt(numLibre));
                //System.out.println(vuelosalto.getSalto_id());
                vuelosalto.setDisponible(0);
                vuelosaltoEJB.create(vuelosalto);
            } else {
                System.out.println("No permitido");
            }

        } catch (Exception e) {
        }
    }

    //****************************************************************************************
    public void leerInformeVuelo(Vuelosalto vueloSeleccionado) {
        vueloSelec = vueloSeleccionado;

        reservaSelec = reservavueloEJB.listarReservas(vueloSelec.getSalto_id());

        total = reservavueloEJB.sumaTotal(vueloSelec.getSalto_id());
        System.out.println("totaaaaall " + reservavueloEJB.sumaTotal(vueloSelec.getSalto_id()));

    }

    public String verificarDisponibilidad() {

        String redireccion = null;
        try {
            if (vueloSelec.getDisponible() != 5) {
                System.out.println("Disponibilidad bien");
                redireccion = "/Vistas/RegistrarVuelosReservas/CreatePasajero?faces-redirect=true";
            } else {
                System.out.println("disponibilidad excedida");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Disponibilidad excedida", ""));
            }

        } catch (Exception e) {
            System.out.println("disponibilidad excedida");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Disponibilidad excedida", ""));
        }
        return redireccion;
    }

    public void registrarPasajero() {
        try {

            System.out.println("ENTREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            reservaRegistro.setNumVuelo(vueloSelec.getSalto_id());
            reservaRegistro.setHorarioVuelo(vueloSelec.getHorario_fecha());
            reservaRegistro.setPasajero(nombreCliente);
            reservaRegistro.setTipo(tipoSalto + " " + tipoPasajero);

            disponiblePas = vueloSelec.getDisponible();
            if (tipoSalto.equals("tandem")) {
                reservaRegistro.setValor(308.0);

                disponiblePas = disponiblePas + 1;
                reservaRegistro.setEquipo(00.0);

            } else if (tipoSalto.equals("libre")) {
                if (vueloSelec.getVuelo_libre() == 1) {
                    reservaRegistro.setValor(40.0);
                } else if (vueloSelec.getVuelo_libre() == 3) {
                    reservaRegistro.setValor(50.0);
                } else if (vueloSelec.getVuelo_libre() == 5) {
                    reservaRegistro.setValor(60.0);
                }

                disponiblePas = disponiblePas + 1;
                reservaRegistro.setEquipo(30.0);
            }
            System.out.println("OBJETOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");

            if (camara.equals("Si")) {
                reservaRegistro.setCamarografo(70.0);
                //disponiblePas = disponiblePas + 1;
            } else if (camara.equals("No")) {
                reservaRegistro.setCamarografo(00.0);
            }

            if (tipoPasajero.equals("instructor") || tipoPasajero.equals("camarografo")) {
                reservaRegistro.setValor(0.00);
                reservaRegistro.setCamarografo(0.00);
                reservaRegistro.setEquipo(0.00);
            }

            totalCliente = reservaRegistro.getValor() + reservaRegistro.getCamarografo() + reservaRegistro.getEquipo();

            reservaRegistro.setTotalcliente(totalCliente);

            reservaRegistro.setTotal(totalCliente + total);
            
            System.out.println("OBJETO TOTAL" + reservaRegistro.getTotal());

            vueloSelec.setDisponible(disponiblePas);

            vuelosaltoEJB.edit(vueloSelec);
            reservavueloEJB.create(reservaRegistro);
            reservavueloEJB.updateTotal(vueloSelec.getSalto_id(), totalCliente + total);

        } catch (Exception e) {
        }
    }
}
