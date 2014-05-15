/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onibus;

import index.ErroInternoException;

/**
 *
 * @author Arthur
 */
public class CadastroOnibus {
    
    private RepositorioOnibus onibus;
    
    public CadastroOnibus(RepositorioOnibus onibus){
        this.onibus = onibus;
    }
    
    public void cadastrar(Onibus onibus) throws ErroInternoException, OnibusExistenteException{
        try {
            Onibus onibus2 = this.onibus.buscar(onibus.getId_onibus());
            throw new OnibusExistenteException();
        } catch (OnibusInexistenteException e){
            this.onibus.cadastrar(onibus);
        }
    }
    
    public Onibus buscar(long id) throws ErroInternoException, OnibusInexistenteException{
        return onibus.buscar(id);
    }
    
    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.editar(onibus);
    }
    
    public void excluir(long id) throws ErroInternoException, OnibusInexistenteException{
        this.onibus.excluir(id);
    }
}
