/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */


@Entity

public class Onibus implements Serializable{
    
    private String placa;
    private long id_onibus;
    private int qnt_assentos;
    private List<Viagem> listaViagem;
  
    
    public Onibus(){
    }
    
    public Onibus(String placa, int qnt_assentos){
        this.placa = placa;
        this.qnt_assentos = qnt_assentos;
    }

    @Column (unique = true)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(long id_onibus) {
        this.id_onibus = id_onibus;
    }

    public int getQnt_assentos() {
        return qnt_assentos;
    }

    public void setQnt_assentos(int qnt_assentos) {
        this.qnt_assentos = qnt_assentos;
    }

    @OneToMany(mappedBy = "onibus")
    public List<Viagem> getListaViagem() {
        return listaViagem;
    }

    public void setListaViagem(List<Viagem> listaViagem) {
        this.listaViagem = listaViagem;
    }
      
}
