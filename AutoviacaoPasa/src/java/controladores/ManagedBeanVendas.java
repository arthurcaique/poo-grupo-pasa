/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import index.Fachada;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import vendas.Venda;
import viagens.Cidades;

/**
 *
 * @author Arthur
 */
@ManagedBean
@SessionScoped
public class ManagedBeanVendas implements Serializable{
    
    @EJB
    private Fachada fachada;
    private Venda venda;
    private EntityManager em;
    private List<Cidades> listaCidades;
    private Cidades origem;
    private Cidades destino;
    
    public ManagedBeanVendas() {
        this.venda = new Venda();
    }

    public ManagedBeanVendas(Venda venda) {
        this.venda = venda;
    }

    public Cidades getOrigem() {
        return origem;
    }

    public void setOrigem(Cidades origem) {
        this.origem = origem;
    }

    public Cidades getDestino() {
        return destino;
    }

    public void setDestino(Cidades destino) {
        this.destino = destino;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Cidades> getListaCidades() {
        return Arrays.asList(Cidades.values());
    }

    public void setListaCidades(List<Cidades> listaCidades) {
        this.listaCidades = listaCidades;
    }
    
}
