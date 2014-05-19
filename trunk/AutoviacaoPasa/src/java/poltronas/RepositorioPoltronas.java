/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;

/**
 *
 * @author Arthur
 */
public interface RepositorioPoltronas {
    public void escolher (Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException;
}
