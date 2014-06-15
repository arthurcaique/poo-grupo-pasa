/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientes;

import com.google.common.base.Objects;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Arthur
 */
@Entity
public class Cliente implements Serializable {
    //Atributos
    private long id_cliente;
    private String senha, nome, cpf, telefone;
    
    //Construtor Vazio
    public Cliente(){
        
    }
    
    //Construtor
    public Cliente(String nome, String cpf, String telefone, String senha){ 
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    
    //Gets e Sets
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Column (name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column (unique = true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null || getClass() != obj.getClass() ){
           return false; 
        }
        final Cliente cliente = (Cliente) obj;
        if(!Objects.equal(this.id_cliente, cliente.id_cliente)){
            return false;
        }
        if(!Objects.equal(this.cpf, cliente.cpf)){
            return false;
        }
        if(!Objects.equal(this.nome, cliente.nome)){
            return false;
        }
        if(!Objects.equal(this.senha, cliente.senha)){
            return false;
        }
        if(!Objects.equal(this.telefone, cliente.telefone)){
            return false;
        }
        return true;
    }
}
