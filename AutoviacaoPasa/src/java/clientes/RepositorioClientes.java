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
public interface RepositorioClientes {
    
    public void adicionar (Cliente c) throws ErroInternoException, ClienteExistenteException;
    public void remover (long id_cliente) throws ErroInternoException, ClienteInexistenteException;
    public Cliente buscar (long id_cliente) throws ErroInternoException, ClienteInexistenteException;
    public void atualizar (Cliente c) throws ErroInternoException, ClienteInexistenteException;
}
