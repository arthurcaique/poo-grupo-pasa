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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author Arthur
 */
@ManagedBean
@RequestScoped
public class ManagedBeanClientes implements Serializable {
    private Fachada fachada;
    private Cliente cliente;
    
    public ManagedBeanClientes(){
        this.cliente = new Cliente();
    }
  

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String adicionarCliente(){
         try{
            this.fachada.adicionar(this.cliente);
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok", "Cliente Cadastrado com sucesso");
            contexto.addMessage(null, msg);                          
        }
        catch(ErroInternoException eie){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro Interno", "Ocorreu um errointerno inesperado!");
            contexto.addMessage(null, msg);
        }
        catch(ClienteExistenteException cee){
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cliente Existente", "Cliente já existe");
            contexto.addMessage(null, msg);
        }
        return null;
    }
    
    public String removerCliente(){
        try{
        this.fachada.remover(cliente.getId_cliente());
        return "index.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInterno.xhtml";
        }
        catch(ClienteInexistenteException cie){
            return "ClienteInexistente.xhtml";
        }
    }
    
    public String buscarCliente(){
        try{
            this.fachada.buscarCliente(cliente.getId_cliente());
            return "InformacoesCliente.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInterno.xhtml";
        }
        catch(ClienteInexistenteException cie){
            return "ClienteInexistente.xhtml";
        }
    }
    
    public String atualizarCliente(){
        try{
            this.fachada.atualizar(cliente);
            return "index.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInterno.xhtml";
        }
        catch(ClienteInexistenteException cie){
            return "ClienteInexistente.xhtml";
        }
    }
        
}
