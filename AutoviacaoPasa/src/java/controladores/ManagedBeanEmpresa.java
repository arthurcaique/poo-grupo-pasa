/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import empresas.Empresa;
import empresas.EmpresaExistenteException;
import empresas.EmpresaInexistenteException;
import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Sabrina Moreira
 */
@ManagedBean
@SessionScoped
public class ManagedBeanEmpresa implements Serializable {

    @EJB
    private Fachada fachada;
    private Empresa empresa;
    private List<Empresa> listaEmpresa;
    private boolean  login;
    
    public ManagedBeanEmpresa() {
        this.empresa = new Empresa();
    }

    public ManagedBeanEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getListaEmpresa() throws ErroInternoException {
        return this.fachada.listaEmpresa();
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    
    
    public String adicionarEmpresa() {
        try {
            this.fachada.adicionar(this.empresa);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Empresa Cadastrada com sucesso");
            contexto.addMessage(null, msg);
            this.empresa = new Empresa();

        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
            return null;
        } catch (EmpresaExistenteException eee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empresa Existente", "Empresa já existe");
            contexto.addMessage(null, msg);
            return null;
        }
        return null;
    }
    public String loginEmpresa(){
        try{
            this.empresa = this.fachada.loginEmpresa(empresa.getCnpj(), empresa.getSenha());
            this.login = true;
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"OK","Empresa logada!");
            contexto.addMessage(null, msg);
            return "index.xhtml";
        }
        catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);
            return null;
        }
        catch(EmpresaInexistenteException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Empresa Inexistente", "A empresa não cadastrada no sistema!");
            contexto.addMessage(null, msg);
            return null;
        }
    }  
        public void logout(){
            login = false;
             this.empresa =  new Empresa();
            
      
        
        
    }

    
    

}
