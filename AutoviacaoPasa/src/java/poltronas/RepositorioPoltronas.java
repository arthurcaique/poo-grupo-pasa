/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;
import java.util.List;

/**
 *
 * @author Arthur
 */
public interface RepositorioPoltronas {
    
    public void adicionar (Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException;
    public Poltrona buscar (long id_poltrona) throws ErroInternoException, PoltronaInexistenteException;
    public List<Poltrona> listar (long id_viagem) throws ErroInternoException;
    
}
