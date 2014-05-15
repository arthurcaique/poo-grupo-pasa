/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viagens;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import motorista.Motorista;
import onibus.Onibus;

/**
 *
 * @author Sabrina Moreira
 */
@Entity
public class Viagem implements Serializable   {
    private Cidades origem;
    private Cidades destino;
    private Date hora;
    private Date data;
    private Onibus onibus;
    private Motorista motorista;
    private long id_viagem;
    
    public Viagem(){
    
}
    public Viagem(Cidades origem, Cidades destino, Date hora, Date data,Onibus onibus, Motorista motorista){
       this.origem = origem;
       this.destino = destino;
       this.hora = hora;
       this.data = data;
       this.onibus= onibus;
       this.motorista = motorista;
        
    }
    
    public void set(Viagem v){
        this.destino= v.destino;
        this.data = v.data;
        this.hora = v.hora;
        this.origem = v.origem;
        this.id_viagem = v.id_viagem;
        this.motorista = v.motorista;
        this.onibus = v.onibus;
        
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
    @Temporal(TemporalType.TIME)
    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @Temporal(TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @OneToMany
    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(long id_viagem) {
        this.id_viagem = id_viagem;
    }
  
    public String toString(){
        return super.toString()+"\n"+ this.data+"\n"+this.destino+"/n"+this.hora+"\n"+this.motorista+"\n"+this.onibus+"/n"+this.id_viagem+"\n"+this.origem;
    }
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(Viagem.class != o.getClass())
            return  false;
            Viagem v = (Viagem)o;
             return(super.equals(v)&& this.data.equals(v.data)&& this.destino.equals(v.destino)&&this.hora.equals(v.hora)&&this.origem.equals(v.origem)&&this.motorista.equals(v.motorista)&&this.onibus.equals(v.onibus)&&super.equals(o));
    }    
    
}
