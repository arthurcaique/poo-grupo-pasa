/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import index.ErroInternoException;

/**
 *
 * @author Arthur
 */
public class CadastroClientes {
    private RepositorioClientes clientes;
    
    public CadastroClientes(RepositorioClientes clientes){
        this.clientes = clientes;
    }
    
    public void adicionar(Cliente c) throws ErroInternoException, ClienteExistenteException{
        try{
        Cliente c2 = this.clientes.buscar(c.getId_cliente());
        throw new ClienteExistenteException();
        }
        catch(ClienteInexistenteException e){
            this.clientes.adicionar(c);
        }
    }
    
    public Cliente buscar(long id_cliente) throws ClienteInexistenteException, ErroInternoException{
        return this.clientes.buscar(id_cliente);
    }
    
    public void atualizar(Cliente c) throws ClienteInexistenteException, ErroInternoException{
        this.clientes.atualizar(c);
    }
    
    public void remover (long id_cliente) throws ErroInternoException, ClienteInexistenteException{
        this.clientes.remover(id_cliente);
    }
}
