/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import index.ErroInternoException;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Arthur
 */
@Stateless
public class CadastroOnibus {
    
    @EJB
    private RepositorioOnibus onibus;
    
    public CadastroOnibus(){
    }
    
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException{
        try {
            Onibus onibus2 = this.onibus.buscarOnibus(onibus.getId_onibus());
            throw new OnibusExistenteException();
        } catch (OnibusInexistenteException e){
            this.onibus.cadastrar(onibus);
        }
    }
    
    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        return onibus.buscarOnibus(id_onibus);
    }
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.editar(onibus);
    }
    
    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.excluir(id_onibus);
    }
}
