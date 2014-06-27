/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import onibus.Onibus;
import onibus.OnibusExistenteException;
import onibus.OnibusInexistenteException;

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
    private List<Onibus> listaOnibus;
    private long onibusSelecionado;

    public long getOnibusSelecionado() {
        return onibusSelecionado;
    }

    public void setOnibusSelecionado(long onibusSelecionado) {
        this.onibusSelecionado = onibusSelecionado;
    }

    public ManagedBeanOnibus() {
        this.onibus = new Onibus();
    }

    public ManagedBeanOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public List<Onibus> getListaOnibus() throws ErroInternoException {
        return this.fachada.listaOnibus();
    }

    public void setListaOnibus(List<Onibus> listaOnibus) {
        this.listaOnibus = listaOnibus;
    }

    public String cadastrarOnibus() throws OnibusExistenteException, ErroInternoException {
        try {
            fachada.cadastrar(onibus);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Onibus cadastrado com sucesso");
            contexto.addMessage(null, msg);
            return "index.xhtml";
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
            return null;
        } catch (OnibusExistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Onibus Existente", "Onibus já existe");
            contexto.addMessage(null, msg);
            return null;
        }
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
