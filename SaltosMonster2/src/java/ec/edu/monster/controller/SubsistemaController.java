/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ModulotreeFacadeLocal;
import ec.edu.monster.ejb.OpcionFacadeLocal;
import ec.edu.monster.ejb.SubsistemaFacadeLocal;
import ec.edu.monster.ejb.UsurolFacadeLocal;
import ec.edu.monster.model.Modulotree;
import ec.edu.monster.model.Opcion;
import ec.edu.monster.model.Subsistema;
import ec.edu.monster.model.Usuario;
import ec.edu.monster.model.Usurol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class SubsistemaController implements Serializable {

    @EJB
    private SubsistemaFacadeLocal EJBSubsistema;
    
    @EJB
    private OpcionFacadeLocal EJBOpcion;

    private List<Subsistema> listaS;
    private List<Opcion> listaO;

    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        this.listarOpciones();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {

        try {
            listaS = EJBSubsistema.findAll();
        } catch (Exception e) {
            //mensaje jsf
        }

    }
    
    public void listarOpciones() {

        try {
            listaO = EJBOpcion.findAll();
        } catch (Exception e) {
            //mensaje jsf
        }

    }    

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    
    @EJB
    private UsurolFacadeLocal usuRolEJB;
    @EJB
    private ModulotreeFacadeLocal treeEJB;
    
    public void establecerPermisos() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        List<Integer> roles = new ArrayList<>();
        List<Integer> opcionesPermitidas = new ArrayList<>();
        List<Integer> subsistemasPermitidos = new ArrayList<>();
        List<Usurol> usuariosRol = usuRolEJB.findAll();
        List<Modulotree> tree = treeEJB.findAll();
        for(Usurol item : usuariosRol){
            if(us.getUsuario_id()==item.getUsuario_id()){
                roles.add(item.getRol_id());
            }
        }
        for(Modulotree item : tree){
            if(roles.contains(item.getRol_id())){
                opcionesPermitidas.add(item.getOpcion_id());
                subsistemasPermitidos.add(item.getSubsistema_id());
            }
        }
        for (Subsistema sub : listaS) {
            if (subsistemasPermitidos.contains(sub.getSubsistema_id())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(sub.getSubsistema_descripcion());
                
                for (Opcion op : listaO) {
                    if(opcionesPermitidas.contains(op.getOpcion_id())&&op.getSubsistema()==sub.getSubsistema_id()){
                        DefaultMenuItem item= new DefaultMenuItem(op.getOpcion_descripcion());
                        item.setUrl("../"+op.getOpcion_vista());
                        firstSubmenu.addElement(item);
                    }
                }
                model.addElement(firstSubmenu);
            }
        }
    }

    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    
}

