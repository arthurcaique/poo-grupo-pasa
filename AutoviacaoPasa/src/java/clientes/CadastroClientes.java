/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import index.ErroInternoException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Arthur
 */
@Stateless
public class CadastroClientes {
    
    @EJB
    private RepositorioClientes clientes;
    
    public CadastroClientes(){
    }
    
    public void adicionar(Cliente cliente) throws ErroInternoException, ClienteExistenteException{
        try{
        Cliente c2 = this.clientes.buscarCliente(cliente.getId_cliente());
        throw new ClienteExistenteException();
        }
        catch(ClienteInexistenteException e){
            this.clientes.adicionar(cliente);
        }
    }
    
    public Cliente buscarCliente(long id_cliente) throws ClienteInexistenteException, ErroInternoException{
        return this.clientes.buscarCliente(id_cliente);
    }
    
    public void atualizar(Cliente cliente) throws ClienteInexistenteException, ErroInternoException{
        this.clientes.atualizar(cliente);
    }
    
    public void remover (long id_cliente) throws ErroInternoException, ClienteInexistenteException{
        this.clientes.remover(id_cliente);
    }
}
