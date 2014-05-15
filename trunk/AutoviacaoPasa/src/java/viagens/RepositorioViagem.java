/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viagens;

import index.ErroInternoException;
import java.util.List;

/**
 *
 * @author Sabrina Moreira
 */
public interface RepositorioViagem {
    
    public void adicionar(Viagem v) throws ErroInternoException;
    
    public void remover(long id_viagem) throws ErroInternoException, ViagemInexistenteException;
    
    public void atualizar(Viagem v) throws ErroInternoException,ViagemInexistenteException;
    
    public void buscar (long id_viagem) throws ErroInternoException, ViagemInexistenteException;
    
    public List<Viagem> buscarPorOnibus (String Placa) throws ErroInternoException;
    
    public List<Viagem> buscarPorMotorista (String nome) throws ErroInternoException;
}
    
           