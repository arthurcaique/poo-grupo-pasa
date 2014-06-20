/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresas;

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
public class Empresa implements Serializable{
    
    private String cnpj, nome, telefone, senha;
    private long id_empresa;
    private List<Viagem> listaViagem;
    
    public Empresa(){     
    }

    public Empresa(String cnpj, String nome, String telefone, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
    }

    @Column (unique = true)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column (unique = true)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }  

    @OneToMany(mappedBy = "empresa")
    public List<Viagem> getListaViagem() {
        return listaViagem;
    }

    public void setListaViagem(List<Viagem> listaViagem) {
        this.listaViagem = listaViagem;
    }
    
}
