/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import index.ErroInternoException;
import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author Arthur
 */
@Local
public interface RepositorioClientes extends Serializable{
    
    public void adicionar (Cliente cliente) throws ErroInternoException, ClienteExistenteException;
    public void remover (long id_cliente) throws ErroInternoException, ClienteInexistenteException;
    public Cliente buscarCliente (long id_cliente) throws ErroInternoException, ClienteInexistenteException;
    public void atualizar (Cliente cliente) throws ErroInternoException, ClienteInexistenteException;
    public Cliente loginCliente(String cpf, String senha) throws ErroInternoException, ClienteInexistenteException;
}
