/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import index.ErroInternoException;
import java.io.Serializable;
import javax.ejb.Local;

/**
 *
 * @author Arthur
 */
@Local
public interface RepositorioOnibus extends Serializable{
    
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException;
    
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException;
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException;
    
    public Onibus buscar(long id) throws ErroInternoException, OnibusInexistenteException;
}