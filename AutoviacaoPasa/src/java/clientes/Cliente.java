/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import pessoas.Pessoa;

/**
 *
 * @author Arthur
 */
@Entity
@Table (name = "clientes")
public class Cliente extends Pessoa implements Serializable {
    //Atributos
    private long id_cliente;
    private String senha;
    
    //Construtor Vazio
    public Cliente(){
        
    }
    
    //Construtor
    public Cliente( String nome, String cpf, String telefone, String senha){
        super(nome, cpf, telefone);  
        this.senha = senha;
    }
    
    //Gets e Sets
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    @Column
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
