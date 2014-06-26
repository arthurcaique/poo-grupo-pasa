/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clientes.Cliente;
import clientes.ClienteExistenteException;
import clientes.ClienteInexistenteException;
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
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanClientes implements Serializable {

    @EJB
    private Fachada fachada;
    private Cliente cliente;
    private EntityManager em;
    private boolean login;

    public ManagedBeanClientes() {
        this.cliente = new Cliente();
    }

    public ManagedBeanClientes(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    
    public String adicionarCliente() {
        try {
            this.fachada.adicionar(this.cliente);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente Cadastrado com sucesso");
            contexto.addMessage(null, msg);
            this.cliente = new Cliente();

        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);

        } catch (ClienteExistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente Existente", "Cliente já existe");
            contexto.addMessage(null, msg);
        } catch (ClienteInexistenteException cie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente Inexistente", "Cliente não existente");
            contexto.addMessage(null, msg);
        }
        return null;
    }

    public String removerCliente() {
        try {
            this.fachada.remover(cliente.getId_cliente());
            return "lista-html.xhtml";
        } catch (ErroInternoException eie) {
            return "ErroInterno.xhtml";
        } catch (ClienteInexistenteException cie) {
            return "ClienteInexistente.xhtml";
        }
    }

    public String buscarCliente() {
        try {
            this.fachada.buscarCliente(cliente.getId_cliente());
            return "InformacoesCliente.xhtml";
        } catch (ErroInternoException eie) {
            return "ErroInterno.xhtml";
        } catch (ClienteInexistenteException cie) {
            return "ClienteInexistente.xhtml";
        }
    }

    public String atualizarCliente() {
        try {
            this.fachada.atualizar(cliente);
            return "index.xhtml";
        } catch (ErroInternoException eie) {
            return "ErroInterno.xhtml";
        } catch (ClienteInexistenteException cie) {
            return "ClienteInexistente.xhtml";
        }
    }

    public String loginCliente() {
        try {
            this.cliente = this.fachada.loginCliente(cliente.getCpf(), cliente.getSenha());
            this.login = true;
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente logado com sucesso");
            contexto.addMessage(null, msg);
            return "index.xhtml";
        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado! " + eie.getMessage());
            contexto.addMessage(null, msg);

        } catch (ClienteInexistenteException cee) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente Inexistente", "O cliente não existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }
    
    public void logout(){
        login = false;
        this.cliente = new Cliente();
    }

    public List<Cliente> listaClientes() throws ErroInternoException {
        try {
            List<Cliente> listaClientes = this.fachada.listaCliente(cliente);
            return listaClientes;
        } catch (ErroInternoException e) {
            throw new ErroInternoException(e);
        }
    }

}
