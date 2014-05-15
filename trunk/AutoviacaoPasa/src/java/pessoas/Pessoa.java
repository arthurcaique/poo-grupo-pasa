/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Arthur
 */
@Entity
public abstract class Pessoa {
    
    //Atributos
    private String nome, cpf, telefone;
    private long codigo;
    
    //Construtor Vazio
    public Pessoa(){
        
    }
    
    //Construtor
    public Pessoa(String nome, String cpf, String telefone, long codigo){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.codigo = codigo;
    }
    
    //Gets e Sets
    @Transient
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Transient
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Transient
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
   
   
   @Id
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    
}
