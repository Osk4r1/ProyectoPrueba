/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.controller;

import ec.edu.monster.ejb.ClienteFacadeLocal;
import ec.edu.monster.ejb.UsuarioFacadeLocal;
import ec.edu.monster.ejb.UsurolFacadeLocal;
import ec.edu.monster.model.Cliente;
import ec.edu.monster.model.Persona;
import ec.edu.monster.model.Usuario;
import ec.edu.monster.model.Usurol;
import java.io.Serializable;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author danie
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    @EJB
    private ClienteFacadeLocal clienteEJB;

    @EJB
    private UsuarioFacadeLocal usuarioEJB;

    @EJB
    private UsurolFacadeLocal usurolEJB;

    private Persona persona;
    private Cliente cliente;
    private Usuario usuario;
    private Usurol usurol;

    private String foto;

    String cedula = "";
    algoritmo algo = new algoritmo();

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        persona = new Persona();
        usuario = new Usuario();
        usurol = new Usurol();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public algoritmo getAlgo() {
        return algo;
    }

    public void setAlgo(algoritmo algo) {
        this.algo = algo;
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

    public ClienteFacadeLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteFacadeLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usurol getUsurol() {
        return usurol;
    }

    public void setUsurol(Usurol usurol) {
        this.usurol = usurol;
    }

    public void doUpload() {
        System.out.println(foto);
        /*
        try{
            InputStream in=image.getInputStream();
            
            File f = new File(""+image.getSubmittedFileName());
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            
            byte[] buffer = new byte[1024];
            int length;
            
            while((length=in.read(buffer))>0){
                out.write(buffer,0,length);
            }
            
            out.close();
            in.close();
            
        }catch(Exception e){
            e.printStackTrace(System.out);
        }*/
    }

    public String GenerarContraseña() {
        Random rdn = new Random();
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int longitud = caracteres.length();
        char letra;
        int longitudContrasenia = 6;
        String contraseniaAleatoria = "";
        for (int i = 0; i < longitudContrasenia; i++) {
            letra = caracteres.charAt(rdn.nextInt(longitud));
            contraseniaAleatoria=contraseniaAleatoria+letra;
        }
        
        return "nuevo";
    }

    public String registrar() {
        String redireccion = null;
        try {

            System.out.println("ced" + cedula.isEmpty());
            if (cedula.isEmpty() || algo.valida(cedula)) {

                persona.setPersona_foto(null);
                persona.setPersona_cedula(cedula);
                this.cliente.setPersona(persona);
                clienteEJB.create(cliente);

                this.usuario.setPersona(persona.getPersona_id());
                this.usuario.setRol(1);
                this.usuario.setUsuario_nombre(cliente.getCliente_correo());

                String encripta=GenerarContraseña();
                String contrasenia = DigestUtils.md5Hex(encripta);//CONTRASE;A

                //usuario.setUsuario_password(encriptado);// CONTRASENA
                usuario.setUsuario_password("nuevo");
                usuario.setEstado(false);
                
                usuarioEJB.create(usuario);

                usurol.setRol_id(usuario.getRol());
                usurol.setUsuario_id(usuario.getUsuario_id());
                usurolEJB.create(usurol);
                redireccion = "/Vistas/GestionarClienteA/Read?faces-redirect=true";

                Correo correo = new Correo();
                correo.enviarCorreo("Contraseña - Sistema de saltos", encripta, "karly.btr.97@hotmail.com");

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La cédula no es válida", ""));
                System.out.println("no es valido");
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "La cédula no es válida", ""));
        }
        return redireccion;
    }
}
