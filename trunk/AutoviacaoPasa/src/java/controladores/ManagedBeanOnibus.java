/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import empresas.Empresa;
import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import onibus.Onibus;
import onibus.OnibusExistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanOnibus implements Serializable {

    @EJB
    private Fachada fachada;
    private Onibus onibus;
    private List<Onibus> listaOnibus;
    private Empresa empresa;

    public ManagedBeanOnibus() {
        this.onibus = new Onibus();
    }


    public List<Onibus> getListaOnibus() throws ErroInternoException {
        return this.fachada.listaOnibus(empresa);
    }

    public void setListaOnibus(List<Onibus> listaOnibus) {
        this.listaOnibus = listaOnibus;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    

    public String cadastrarOnibus() throws OnibusExistenteException, ErroInternoException {
        try {
            this.onibus.setEmpresa(empresa);
            this.fachada.cadastrar(this.onibus);          
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Onibus cadastrado com sucesso");
            contexto.addMessage(null, msg);
            this.onibus = new Onibus();
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
            
        } catch (OnibusExistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Onibus Existente", "Onibus já existe");
            contexto.addMessage(null, msg);
            
        }
        return null;
    }

    public Fachada getFachada() {
        return fachada;
    }

    public void setFachada(Fachada fachada) {
        this.fachada = fachada;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

}
