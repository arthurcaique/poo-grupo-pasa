/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

/**
 *
 * @author Arthur
 */
public class ClienteInexistenteException extends Exception {
    public ClienteInexistenteException(){
        super("Cliente não cadastrado!");
    }
}
