/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.OpcionFacadeLocal;
import ec.edu.monster.model.Opcion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class OpcionController implements Serializable{
    
    @EJB
    private OpcionFacadeLocal EJBOpcion;
    private List<Opcion> listaO;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        this.listarMenus();
        model=new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {

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
   
    public void establecerPermisos() {

        //Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        for (Opcion m : listaO) {
            DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getOpcion_descripcion());
            model.addElement(firstSubmenu);

        }

        /*
        for (Subsistema m : listaS) {
            if (m.getRol_id()==us.getRol()) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getSubsistema_descripcion());
                
                for (Opcion i : listaO) {
                    if(i.getSubsistema() == m.getSubsistema_id()){
                        DefaultMenuItem item= new DefaultMenuItem(i.getOpcion_descripcion());
                        firstSubmenu.addElement(item);
                    }
                }
                model.addElement(firstSubmenu);
            }

        }*/

 /*
        for(Subsistema m:listaS ){ 
            if(m.getRol().getRol_descripcion().equals("Cliente")){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getSubsistema_descripcion());
                for(Opcion i:listaO){
                    Subsistema submenu= i.getSubsistema();
                }
            }
        }*/
    }    
    
}
