/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ModulotreeFacadeLocal;
import ec.edu.monster.ejb.OpcionFacadeLocal;
import ec.edu.monster.ejb.RolFacadeLocal;
import ec.edu.monster.ejb.SubsistemaFacadeLocal;
import ec.edu.monster.ejb.UsuarioFacadeLocal;
import ec.edu.monster.model.Modulotree;
import ec.edu.monster.model.Opcion;
import ec.edu.monster.model.Rol;
import ec.edu.monster.model.Subsistema;
import ec.edu.monster.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author danie
 */
@Named
@SessionScoped
public class RolesOpcionesController implements Serializable {

    @EJB
    private RolFacadeLocal rolEJB;
    private Rol rol;
    private Rol rolCreate;
    private List<Rol> roles;
    private Subsistema subsistemaCreate;

    @EJB
    private SubsistemaFacadeLocal subsistemaEJB;
    private List<Subsistema> subsistemas;
    private List<Subsistema> subsistemasNo;
    private Subsistema subsistema;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    private List<Subsistema> subsistemaSi;
    private List<Subsistema> subsistemaNo;

    @EJB
    private OpcionFacadeLocal opcionEJB;
    private Opcion opcion;
    private List<Opcion> opcionSi;
    private List<Opcion> opcionNo;

    private String rolid;
    private String opValid;
    private String opNoValid;
    private TreeNode root = null;

    public String getRolid() {
        return rolid;
    }

    public void setRolid(String rolid) {
        this.rolid = rolid;
    }

    public String getOpValid() {
        return opValid;
    }

    public void setOpValid(String opValid) {
        this.opValid = opValid;
    }

    public String getOpNoValid() {
        return opNoValid;
    }

    public void setOpNoValid(String opNoValid) {
        this.opNoValid = opNoValid;
    }

    public Subsistema getSubsistemaCreate() {
        return subsistemaCreate;
    }

    public void setSubsistemaCreate(Subsistema subsistemaCreate) {
        this.subsistemaCreate = subsistemaCreate;
    }

    public List<Subsistema> getSubsistemasNo() {
        return subsistemasNo;
    }

    public void setSubsistemasNo(List<Subsistema> subsistemasNo) {
        this.subsistemasNo = subsistemasNo;
    }

    public List<Subsistema> getSubsistemas() {
        return subsistemas;
    }

    public void setSubsistemas(List<Subsistema> subsistemas) {
        this.subsistemas = subsistemas;
    }

    //U
    private int selectedItemIndex;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Rol getRolCreate() {
        return rolCreate;
    }

    public void setRolCreate(Rol rolCreate) {
        this.rolCreate = rolCreate;
    }

    public Subsistema getSubsistema() {
        return subsistema;
    }

    public void setSubsistema(Subsistema subsistema) {
        this.subsistema = subsistema;
    }

    public List<Subsistema> getSubsistemaSi() {
        return subsistemaSi;
    }

    public void setSubsistemaSi(List<Subsistema> subsistemaSi) {
        this.subsistemaSi = subsistemaSi;
    }

    public List<Subsistema> getSubsistemaNo() {
        return subsistemaNo;
    }

    public void setSubsistemaNo(List<Subsistema> subsistemaNo) {
        this.subsistemaNo = subsistemaNo;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public List<Opcion> getOpcionSi() {
        return opcionSi;
    }

    public void setOpcionSi(List<Opcion> opcionSi) {
        this.opcionSi = opcionSi;
    }

    public List<Opcion> getOpcionNo() {
        return opcionNo;
    }

    public void setOpcionNo(List<Opcion> opcionNo) {
        this.opcionNo = opcionNo;
    }

    @PostConstruct
    public void init() {
        roles = rolEJB.findAll();
        try {
            //usuario = usuarioEJB.usuarioRol(1);
            //usuarioNo = usuarioEJB.usuarioNoRol(1);
        } catch (Exception e) {

        }

        rol = new Rol();
        rolCreate = new Rol();
        subsistema = new Subsistema();
        subsistemaCreate = new Subsistema();
        opcion = new Opcion();
    }

    @EJB
    private ModulotreeFacadeLocal treeEJB;
    private TreeNode[] selectedNodes;

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }

    public void guardarPermisos(TreeNode[] nodes) throws Exception {

        if (nodes != null && rolid != null) {

            int idRol = rolEJB.getRolId(rolid).getRol_id();

            for (Modulotree item : treeEJB.findAll()) {
                if (item.getRol_id() == idRol) {
                    treeEJB.remove(item);
                }
            }

            for (TreeNode node : nodes) {
                if (!node.getParent().toString().equals("root")) {
                    //System.out.println(node.getData().toString());
                    int idSubsistema = subsistemaId(node.getParent().toString());
                    int idOpcion = opcionId(node.getData().toString());

                    if (idRol != 0 && idSubsistema != 0) {
                        Modulotree permiso = new Modulotree();
                        permiso.setOpcion_id(idOpcion);
                        permiso.setRol_id(idRol);
                        permiso.setSubsistema_id(idSubsistema);
                        treeEJB.create(permiso);
                    }
                }
            }
        }
    }

    public int subsistemaId(String nombreSubsistema) {
        int id = 0;
        for (Subsistema sub : subsistemaEJB.findAll()) {
            if (sub.getSubsistema_descripcion().equals(nombreSubsistema)) {
                id = sub.getSubsistema_id();
                break;
            }
        }
        return id;
    }

    public int opcionId(String nombreOpcion) {
        int id = 0;
        for (Opcion op : opcionEJB.findAll()) {
            if (op.getOpcion_descripcion().equals(nombreOpcion)) {
                id = op.getOpcion_id();
                break;
            }
        }
        return id;
    }

    public TreeNode miTree() {

        List<Modulotree> tree = treeEJB.findAll();
        List<Subsistema> subsistemas = subsistemaEJB.findAll();
        List<Opcion> opciones = opcionEJB.findAll();
        int idRol = 0;

        if (rolid != null) {
            try {
                idRol = rolEJB.getRolId(rolid).getRol_id();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        root = new DefaultTreeNode("Root", null);

        for (Subsistema sub : subsistemas) {

            TreeNode node2 = new DefaultTreeNode(sub.getSubsistema_descripcion(), root);

            for (Opcion op : opciones) {

                if (op.getSubsistema() == sub.getSubsistema_id()) {

                    TreeNode node3 = new DefaultTreeNode(op.getOpcion_descripcion(), node2);
                    node3.setSelected(false);
                    for (Modulotree item : tree) {
                        if (idRol != 0) {
                            if (item.getRol_id() == idRol && item.getOpcion_id() == op.getOpcion_id()) {
                                node3.setSelected(true);
                                break;
                            }
                        }
                    }

                }
            }
        }
        return root;
    }

    public void registrar() {
        try {

            subsistemaCreate.setRol_id(18);

            subsistemaEJB.create(subsistemaCreate);

        } catch (Exception e) {
        }

    }

    public Rol getSelected() {

        if (rol == null) {
            rol = new Rol();
            selectedItemIndex = -1;
        }
        return rol;
    }

    /*
    public void recuperarRoles(){
        rol=rolEJB.findAll();
    }
     */
 /*
    public List<Subsistema> leerOp() {

        
        try {
            Rol rols = rolEJB.getRolId(rolid);
            subsistemaSi = subsistemaEJB.listarSubsistemas(rols.getRol_id());
        } catch (Exception e) {

        }

        return subsistemaSi;

    }*/
    public List<Opcion> leerOp() {

        try {
            Rol rols = rolEJB.getRolId(rolid);
            opcionSi = opcionEJB.listarSubsistemas(rols.getRol_id());
        } catch (Exception e) {

        }

        return opcionSi;

    }

    /**
     * ***********************************************
     */
    /*
    public List<Subsistema> leerOpNo() {
        try {
            Rol rols = rolEJB.getRolId(rolid);
            subsistemaNo = subsistemaEJB.listarNoSubsistemas(rols.getRol_id());
        } catch (Exception e) {

        }
        return subsistemaNo;
    }*/
    public List<Opcion> leerOpNo() {
        try {
            Rol rols = rolEJB.getRolId(rolid);
            opcionNo = opcionEJB.listarNoSubsistemas(rols.getRol_id());
        } catch (Exception e) {

        }

        return opcionNo;
    }

    public void leer(Rol rolSeleccion) {
        rol = rolSeleccion;
        subsistemas = subsistemaEJB.listarSubsistemas(rol.getRol_id());
        subsistemasNo = subsistemaEJB.listarNoSubsistemas(rol.getRol_id());
    }

    public void addPermiso(Subsistema subsistemaSeleccion) {
        subsistema = subsistemaSeleccion;
        subsistema.setRol_id(rol.getRol_id());
        //System.out.println(rol.getRol_id());
        subsistemaEJB.create(subsistema);
    }

    public void update() {

        try {
            rolEJB.edit(rol);
        } catch (Exception e) {

        }
    }

    public void guardado() {

        subsistemasNo = subsistemaEJB.listarNoSubsistemas(rol.getRol_id());
    }

    public void actualizar() {

        //Recuperar usuario  
        try {

            Subsistema subsistemap = subsistemaEJB.subsistemaObjeto(opNoValid);
            Rol rols = rolEJB.getRolId(rolid);
            subsistemap.setRol_id(rols.getRol_id());
            subsistemaEJB.edit(subsistemap);

        } catch (Exception e) {

        }

    }

    public void regresar() {

        //Recuperar usuario  
        try {
            Subsistema subistemap = subsistemaEJB.subsistemaObjeto(opValid);
            Rol rols = rolEJB.getRolId("No asignado");
            subistemap.setRol_id(rols.getRol_id());
            subsistemaEJB.edit(subistemap);

        } catch (Exception e) {

        }
    }

}
