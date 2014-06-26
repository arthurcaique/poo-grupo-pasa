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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public String listaEmpresa() {
        try {
            this.empresa.setListaEmpresa(this.fachada.listaEmpresa());
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.FACES_MESSAGES, "Essas são as empresa filiadas ao site");
            contexto.addMessage(null, msg);
            return null;

        } catch (ErroInternoException eie) {
            FacesContext contexto = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro Interno", "Ocorreu um erro interno inesperado!" + eie.getMessage());
            contexto.addMessage(null, msg);
            return null;
        }
    }

}
