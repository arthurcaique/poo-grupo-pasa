/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import onibus.Onibus;
import onibus.OnibusExistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
@RequestScoped
public class ManagedBeanOnibus {

    @EJB
    private Fachada fachada;
    private Onibus onibus;

    public ManagedBeanOnibus() {
    }
    
    public ManagedBeanOnibus(Onibus onibus){
        this.onibus = onibus;
    }

    public String cadastrarOnibus() throws OnibusExistenteException, ErroInternoException {
        try {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente Cadastrado com sucesso");
            contexto.addMessage(null, msg);
            fachada.cadastrar(onibus);
            return "index.xhtml";
        }catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
            return null;
        }
        catch(OnibusExistenteException cee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Onibus Existente", "Onibus já existe");
            contexto.addMessage(null, msg);
            return null;
        }
    }
}
