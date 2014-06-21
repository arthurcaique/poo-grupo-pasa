/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package index;

import clientes.CadastroClientes;
import clientes.Cliente;
import clientes.ClienteExistenteException;
import clientes.ClienteInexistenteException;
import empresas.CadastroEmpresa;
import empresas.Empresa;
import empresas.EmpresaExistenteException;
import empresas.EmpresaInexistenteException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import onibus.CadastroOnibus;
import onibus.Onibus;
import onibus.OnibusExistenteException;
import onibus.OnibusInexistenteException;
import poltronas.CadastroPoltrona;
import poltronas.Poltrona;
import poltronas.PoltronaIndisponivelException;
import poltronas.PoltronaInexistenteException;
import vendas.CadastroVenda;
import vendas.Venda;
import vendas.VendaInexistenteException;
import viagens.CadastroViagem;
import viagens.Viagem;
import viagens.ViagemExistenteException;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class Fachada implements Serializable{
    @EJB
    private CadastroClientes cliente;
    @EJB
    private CadastroEmpresa empresa;
    @EJB
    private CadastroOnibus onibus;
    @EJB
    private CadastroPoltrona poltrona;
    @EJB
    private CadastroVenda venda;
    @EJB
    private CadastroViagem viagem; 
    
    public Fachada(){
        
    }
    
    public void adicionar(Cliente c) throws ErroInternoException, ClienteExistenteException{
       this.cliente.adicionar(c);
    }
    
    public Cliente buscarCliente(long id_cliente) throws ClienteInexistenteException, ErroInternoException{
        return this.cliente.buscarCliente(id_cliente);
    }
    
    public void atualizar(Cliente c) throws ClienteInexistenteException, ErroInternoException{
        this.cliente.atualizar(c);
    }
    
    public void remover (long id_cliente) throws ErroInternoException, ClienteInexistenteException{
        this.cliente.remover(id_cliente);
    }   
    
    public Cliente loginCliente(String cpf, String senha) throws ErroInternoException, ClienteInexistenteException{
        return this.cliente.loginCliente(cpf, senha);
    }
     public void adicionar(Empresa ep) throws ErroInternoException, EmpresaExistenteException{
       this.empresa.adicionar(ep);
        
    }
    public void remove(long Id_empresa) throws EmpresaInexistenteException, ErroInternoException{
        this.empresa.remove(Id_empresa);
    }

  public Empresa buscarEmpresa(long Id_empresa) throws EmpresaInexistenteException, ErroInternoException{
       return this.empresa.buscarEmpresa(Id_empresa);
    } 
    public void atualizar(Empresa ep) throws EmpresaInexistenteException, ErroInternoException{
        this.empresa.atualizar(ep);
    }
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException{
       this.onibus.cadastrar(onibus);
    }
    
    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        return onibus.buscarOnibus(id_onibus);
    }
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.editar(onibus);
    }
    
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.excluir(id_onibus);
    }
    
    public void adicionar(Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException{
      this.poltrona.adicionar(p);
    }
    
    public List<Poltrona> listar (long id_viagem) throws ErroInternoException{
        return this.poltrona.listar(id_viagem);
    }
    
    public Poltrona buscarPoltrona (long id_poltrona) throws ErroInternoException, PoltronaInexistenteException{
        return this.poltrona.buscarPoltrona(id_poltrona);
    }
     public void adicionar(Venda venda) throws ErroInternoException{
        this.venda.adicionar(venda);
    }
    
    public Venda buscarVenda(long id) throws ErroInternoException, VendaInexistenteException{
        return this.venda.buscarVenda(id);
    }
    
    public List<Venda> vendasPorViagem(long id_viagem) throws ErroInternoException, VendaInexistenteException{
         return  this.venda.vendasPorViagem(id_viagem);
    }
    
     public void adicionar(Viagem v) throws ErroInternoException, ViagemExistenteException{
        this.viagem.adicionar(v);
        }
     
    public void removeViagem(long Id_viagem) throws ViagemInexistenteException, ErroInternoException{
        this.viagem.removeViagem(Id_viagem);
    }

    public Viagem buscarViagem(long Id_viagem) throws ViagemInexistenteException, ErroInternoException{
       return this.viagem.buscarViagem(Id_viagem);
    } 
    public void atualizar(Viagem v) throws ViagemInexistenteException, ErroInternoException{
        this.viagem.atualizar(v);
    }
       
    
}

