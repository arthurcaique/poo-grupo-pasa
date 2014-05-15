/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import java.io.Serializable;
import javax.persistence.Column;

/**
 *
 * @author Arthur
 */

public abstract class Pessoa implements Serializable {
    
    //Atributos
    private String nome, cpf, telefone;
    //Construtor Vazio
    public Pessoa(){
        
    }
    
    //Construtor
    public Pessoa(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    //Gets e Sets  
  
    @Column
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column (unique=true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Column
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }  
    
}
