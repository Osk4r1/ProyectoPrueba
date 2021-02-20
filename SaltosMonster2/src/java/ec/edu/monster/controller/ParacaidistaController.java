/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.CursoFacadeLocal;
import ec.edu.monster.ejb.LicenciaFacadeLocal;
import ec.edu.monster.ejb.ParacaidistaFacadeLocal;
import ec.edu.monster.ejb.UsuarioFacadeLocal;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Curso;
import ec.edu.monster.model.Licencia;
import ec.edu.monster.model.Paracaidista;
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
public class ParacaidistaController implements Serializable {

    @EJB
    private ParacaidistaFacadeLocal paracaidistaEJB;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    @EJB
    private ClienteFacadeLocal clienteEJB;

    @EJB
    private CursoFacadeLocal cursoEJB;

    @EJB
    private LicenciaFacadeLocal licenciaEJB;

    private Paracaidista paracaidista;
    private Cliente cliente;
    private Usuario usuario;
    private Curso cursoAgua;
    private Curso cursoCupula;
    private Licencia licencia;

    private boolean cursoA;
    private boolean cursoC;
    private boolean lic;
    private Usuario us;

    @PostConstruct
    public void init() {
        paracaidista = new Paracaidista();
        cliente = new Cliente();
        usuario = new Usuario();
        cursoAgua = new Curso();
        cursoCupula = new Curso();
        licencia = new Licencia();
        this.recuperarCliente();
    }

    public Paracaidista getParacaidista() {
        return paracaidista;
    }

    public void setParacaidista(Paracaidista paracaidista) {
        this.paracaidista = paracaidista;
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
            cliente = clienteEJB.encontrarPersona(us.getPersona());
            //cliente = clienteEJB.find(us.)
        } catch (Exception e) {
            //mensaje jsf
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCursoAgua() {
        return cursoAgua;
    }

    public void setCursoAgua(Curso cursoAgua) {
        this.cursoAgua = cursoAgua;
    }

    public Curso getCursoCupula() {
        return cursoCupula;
    }

    public void setCursoCupula(Curso cursoCupula) {
        this.cursoCupula = cursoCupula;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public boolean isCursoA() {
        return cursoA;
    }

    public void setCursoA(boolean cursoA) {
        this.cursoA = cursoA;
    }

    public boolean isCursoC() {
        return cursoC;
    }

    public void setCursoC(boolean cursoC) {
        this.cursoC = cursoC;
    }

    public boolean isLic() {
        return lic;
    }

    public void setLic(boolean lic) {
        this.lic = lic;
    }
    

    public void registrar() {

        try {
            us.setRol(3);
            usuarioEJB.edit(us);
            //System.out.println("PARACAIDISTA CONTROLLER"+ cliente.getCliente_id());
            this.paracaidista.setCliente_id(cliente.getCliente_id());
            //System.out.println("PARACAIDISTA CONTROLLER "+ usuario.getPersona());
            this.paracaidista.setPersona_id(us.getPersona());
            paracaidistaEJB.create(paracaidista);
            //CUPULA
            if (cursoC) {
                this.cursoCupula.setCliente_id(cliente.getCliente_id());
                this.cursoCupula.setParacaidista_id(paracaidista.getParacaidista_id());
                this.cursoCupula.setCurso_tipo("Cupula");
                cursoEJB.create(cursoCupula);
            }
            //AGUA
            if (cursoA) {
                this.cursoAgua.setCliente_id(cliente.getCliente_id());
                this.cursoAgua.setParacaidista_id(paracaidista.getParacaidista_id());
                this.cursoAgua.setCurso_tipo("Agua");
                cursoEJB.create(cursoAgua);
            }

            //LICENCIA
            this.licencia.setCliente_id(cliente.getCliente_id());
            this.licencia.setParacaidista_id(paracaidista.getParacaidista_id());
            licenciaEJB.create(licencia);
        } catch (Exception e) {
        }
    }

}
