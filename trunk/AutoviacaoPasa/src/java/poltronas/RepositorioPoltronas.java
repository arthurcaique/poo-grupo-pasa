/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;
import java.util.List;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
public interface RepositorioPoltronas {
    public void adicionar (Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException;
    public List<Poltrona> listar (Viagem viagem) throws ErroInternoException;
}
