/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import poltronas.Poltrona;
import poltronas.PoltronaIndisponivelException;
import poltronas.PoltronaInexistenteException;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
@ManagedBean
@RequestScoped
public class ManagedBeanPoltrona implements Serializable {
    
    private Fachada fachada;
    private Poltrona poltrona;
    private Viagem viagem;
    
    public ManagedBeanPoltrona(Poltrona poltrona){
        this.poltrona = poltrona;
    }

    public Poltrona getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Poltrona poltrona) {
        this.poltrona = poltrona;
    }
    
    public String adicionarPoltrona(){
        try{
            this.fachada.adicionar(this.poltrona);
            this.poltrona = new Poltrona();
            return "index.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInterno.xhtml";
        }
        catch(PoltronaIndisponivelException pei){
            return "PoltronaIndisponivel.xhtml";
        }
        catch(PoltronaInexistenteException pie){
            return "Poltrona Inexistente.xhtml";
        }
    }
    
    public String buscarPoltrona(){
        try{
            this.fachada.buscarPoltrona(this.poltrona.getId_poltrona());
            return "Poltrona.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInternoException.xhtml";
        }
        catch(PoltronaInexistenteException pie){
            return "PoltronaInexistenteException.xhtml";
        }
    }
    
    public String listarPoltrona(){
        try{
            this.fachada.listar(this.viagem.getId_viagem());
            return "ListaPoltronas.xhtml";
        }
        catch(ErroInternoException eie){
            return "ErroInterno.xhtml";
        }
        
    }
}
