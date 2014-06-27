/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import viagens.Viagem;
import viagens.ViagemExistenteException;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanViagem implements Serializable {

    @EJB
    private Fachada fachada;
    private Viagem viagem;
    private long viagemSelecionada;
    private List<Viagem> listaViagens;

    public ManagedBeanViagem() {
        this.viagem = new Viagem();
    }

    public long getViagemSelecionada() {
        return viagemSelecionada;
    }

    public void setViagemSelecionada(long viagemSelecionada) {
        this.viagemSelecionada = viagemSelecionada;
    }

    public List<Viagem> getListaViagens() {
        return listaViagens;
    }

    public void setListaViagens(List<Viagem> listaViagens) {
        this.listaViagens = listaViagens;
    }
    
    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public String formatarData(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }

    public String formatarHora(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(data);
    }

    public String viagemSelecionada(long id) throws ViagemInexistenteException, ErroInternoException {
        this.fachada.buscarViagem(id);
        return "lista-poltrona";
    }

    public String adicionarViagem() {
        try {
            this.fachada.adicionar(this.viagem);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Viagem Cadastrada com sucesso");
            contexto.addMessage(null, msg);
            this.viagem = new Viagem();

        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);

        } catch (ViagemExistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Viagem Existente", "Viagem já existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }

    public String consultaViagens() {
        try {
            this.listaViagens = (this.fachada.consultaViagens(viagem.getOrigem(), viagem.getDestino(), viagem.getData()));
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Exibindo viagens de " + viagem.getOrigem() + " para " + viagem.getDestino() + " em " + formatarData(viagem.getData()));
            contexto.addMessage(null, msg);
            return "lista-onibus.xhtml";
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Não existe nenhuma viagem de " + viagem.getOrigem() + " para " + viagem.getDestino() + " em " + formatarData(viagem.getData()));
            contexto.addMessage(null, msg);

        } catch (ViagemInexistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Viagem Inexistente", "A viagem não existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }
}
