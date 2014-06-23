/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import clientes.ClienteInexistenteException;
import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import vendas.Venda;
import viagens.Cidades;
import viagens.Viagem;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanViagem implements Serializable{
    
    @EJB
    private Fachada fachada;
    private Viagem viagem;
    private EntityManager em;
    
    public ManagedBeanViagem() {
        this.viagem = new Viagem();
    }

    public ManagedBeanViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
    
    public String consultaViagens(){
        try {
           this.fachada.consultaViagens(viagem.getOrigem(), viagem.getDestino(), viagem.getData());
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", viagem.getEmpresa() + " " + viagem.getHora());
            contexto.addMessage(null, msg);
            //return "lista-onibus.xhtml";
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);

        } catch (ViagemInexistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Viagem Inexistente", "A viagem não existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }

    
}
