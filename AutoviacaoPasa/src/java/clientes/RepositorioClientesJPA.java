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
    public void adicionar(Cliente c) throws ErroInternoException, ClienteExistenteException {
        try{
            this.em.persist(c);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }

    @Override
    public void remover(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        Cliente c = this.buscarCliente(id_cliente);
        try{
            this.em.remove(c);
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
    public void atualizar(Cliente c) throws ErroInternoException, ClienteInexistenteException {
        this.buscarCliente(c.getId_cliente());
        try{
            this.em.merge(c);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }
    
}
