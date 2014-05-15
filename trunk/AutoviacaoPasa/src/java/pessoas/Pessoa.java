/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Arthur
 */
@Entity
public abstract class Pessoa implements Serializable {
    
    //Atributos
    private long id_pessoa;
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
    @Id
    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    
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
