/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresas;

import com.sun.xml.ws.developer.StreamingAttachment;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
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
    private List<Empresa> listaEmpresa;
    
    public Empresa(){     
    }

    public Empresa(String cnpj, String nome, String telefone, String senha) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        
    }
    @Transient
    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }
    
   // @Column (unique = true)
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

    //@Column (unique = true)
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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.listaViagem, other.listaViagem)) {
            return false;
        }
        if (!Objects.equals(this.listaEmpresa, other.listaEmpresa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cnpj=" + cnpj + ", nome=" + nome + ", telefone=" + telefone + ", senha=" + senha + ", id_empresa=" + id_empresa + ", listaViagem=" + listaViagem + ", listaEmpresa=" + listaEmpresa + '}';
    }
    
    
    
}
