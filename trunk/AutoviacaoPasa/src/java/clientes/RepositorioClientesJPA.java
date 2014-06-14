/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import index.ErroInternoException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Arthur
 */
@Stateless
public class RepositorioClientesJPA implements RepositorioClientes {
    
    EntityManager em;
    
    @Override
    public void adicionar(Cliente cliente) throws ErroInternoException, ClienteExistenteException {
        try{
            this.em.persist(cliente);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }

    @Override
    public void remover(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        Cliente cliente = this.buscarCliente(id_cliente);
        try{
            this.em.remove(cliente);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }

    @Override
    public Cliente buscarCliente(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        return this.em.find(Cliente.class, id_cliente);
    }

    @Override
    public void atualizar(Cliente cliente) throws ErroInternoException, ClienteInexistenteException {
        this.buscarCliente(cliente.getId_cliente());
        try{
            this.em.merge(cliente);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }
    
}
