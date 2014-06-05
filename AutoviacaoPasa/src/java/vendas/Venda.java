/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vendas;

import clientes.Cliente;
import empresas.Empresa;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import onibus.Onibus;
import poltronas.Poltrona;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
@Entity
public class Venda implements Serializable{
    private Cliente id_cliente;
    private Empresa id_empresa;
    private Onibus id_onibus;
    private Poltrona id_poltrona;
    private Viagem id_viagem;
    private double preco;
    private long codigo;
    
    
    public Venda(){
        
    }
    public Venda(Cliente id_cliente, Empresa id_empresa, Onibus id_onibus, Poltrona id_poltrona, Viagem id_viagem, double preco){
        this.id_cliente = id_cliente;
        this.id_empresa = id_empresa;
        this.id_onibus = id_onibus;
        this.id_poltrona = id_poltrona;
        this.id_viagem = id_viagem;
        this.preco = preco; 
    }
    
    public void set(Venda ven){
       
        this.id_cliente = ven.id_cliente;
        this.id_empresa = ven.id_empresa;
        this.id_onibus = ven.id_onibus;
        this.id_poltrona = ven.id_poltrona;
        this.id_viagem = ven.id_viagem;
        this.preco = ven.preco;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Empresa getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Empresa id_empresa) {
        this.id_empresa = id_empresa;
    }

    public Onibus getId_onibus() {
        return id_onibus;
    }

    public void setId_onibus(Onibus id_onibus) {
        this.id_onibus = id_onibus;
    }

    public Poltrona getId_poltrona() {
        return id_poltrona;
    }

    public void setId_poltrona(Poltrona id_poltrona) {
        this.id_poltrona = id_poltrona;
    }

    public Viagem getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(Viagem id_viagem) {
        this.id_viagem = id_viagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    public String ToString(){
        return (this.codigo+"\n"+this.preco+"\n"+this.id_cliente+"\n"+this.id_empresa+"\n"+this.id_onibus+"\n"+this.id_poltrona+"\n"+this.id_viagem);
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id_cliente, other.id_cliente)) {
            return false;
        }
        if (!Objects.equals(this.id_empresa, other.id_empresa)) {
            return false;
        }
        if (!Objects.equals(this.id_onibus, other.id_onibus)) {
            return false;
        }
        if (!Objects.equals(this.id_poltrona, other.id_poltrona)) {
            return false;
        }
        if (!Objects.equals(this.id_viagem, other.id_viagem)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
    
    
}
