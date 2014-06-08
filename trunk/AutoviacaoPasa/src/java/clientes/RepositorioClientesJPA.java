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
public class RepositorioClientesJPA implements RepositorioClientes {

    @Override
    public void adicionar(Cliente c) throws ErroInternoException, ClienteExistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarCliente(long id_cliente) throws ErroInternoException, ClienteInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Cliente c) throws ErroInternoException, ClienteInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
