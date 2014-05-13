/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas;

/**
 *
 * @author Arthur
 */
public abstract class Pessoa {
    
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
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
    
    
    
    
    
}
