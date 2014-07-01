/*] * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import poltronas.Poltrona;
import poltronas.PoltronaIndisponivelException;
import poltronas.PoltronaInexistenteException;
import vendas.Venda;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanPoltrona implements Serializable {

    @EJB
    private Fachada fachada;
    private Poltrona poltrona;
    private Viagem viagem;
    private long poltronaSelecionada;

    public ManagedBeanPoltrona() {
        this.poltrona = new Poltrona();
    }

    public long getPoltronaSelecionada() {
        return poltronaSelecionada;
    }

    public void setPoltronaSelecionada(long poltronaSelecionada) {
        this.poltronaSelecionada = poltronaSelecionada;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }

    public Poltrona adicionarPoltrona() {
        try {
            this.poltrona.setNumero_poltrona(poltronaSelecionada);
            this.fachada.adicionar(this.poltrona);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Poltrona cadastrada com sucesso");
            contexto.addMessage(null, msg);
            //this.poltrona = new Poltrona();
            return this.poltrona;
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
        } catch (PoltronaIndisponivelException pei) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Poltrona Indisponivel", "Essa poltrona não está disponível");
            contexto.addMessage(null, msg);
        } catch (PoltronaInexistenteException pie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Poltrona Inexistente", "Essa poltrona não existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }

    public List<Poltrona> poltronasCompradas(Viagem viagem) throws ErroInternoException {
        return fachada.poltronasCompradas(viagem);
    }

    public String buscarPoltrona() {
        try {
            this.fachada.buscarPoltrona(this.poltrona.getId_poltrona());
            return "Poltrona.xhtml";
        } catch (ErroInternoException eie) {
            return "ErroInternoException.xhtml";
        } catch (PoltronaInexistenteException pie) {
            return "PoltronaInexistenteException.xhtml";
        }
    }

    public String listarPoltrona() {
        try {
            this.fachada.listar(this.viagem.getId_viagem());
            return "ListaPoltronas.xhtml";
        } catch (ErroInternoException eie) {
            return "ErroInterno.xhtml";
        }

    }
}
