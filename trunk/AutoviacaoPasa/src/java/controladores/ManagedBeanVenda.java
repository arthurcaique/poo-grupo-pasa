/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

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
import vendas.Venda;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanVenda implements Serializable {

    @EJB
    private Fachada fachada;
    private Venda venda;

    public ManagedBeanVenda() {
        this.venda = new Venda();
    }

    public String cadastrarVenda() throws OnibusExistenteException, ErroInternoException {
        try {
            this.fachada.adicionar(this.venda);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Venda realizada com sucesso");
            contexto.addMessage(null, msg);
            this.venda = new Venda();
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
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

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
