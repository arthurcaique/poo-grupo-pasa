/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viagens;

import index.ErroInternoException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import onibus.RepositorioOnibus;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class CadastroViagem {
    @EJB
    private RepositorioViagem viagem;
    
    public CadastroViagem(){
        
    }
    
    public void adicionar(Viagem v) throws ErroInternoException, ViagemExistenteException{
        try{
            Viagem viagem2 =  this.viagem.buscar(v.getId_viagem());
            throw new ViagemExistenteException();
     
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
        
    }
    
    public void remove(long Id_viagem) throws ViagemInexistenteException, ErroInternoException{
        this.viagem.remover(Id_viagem);
    }

    public Viagem buscar(long Id_viagem) throws ViagemInexistenteException, ErroInternoException{
       return this.viagem.buscar(Id_viagem);
    } 
    public void atualizar(Viagem v) throws ViagemInexistenteException, ErroInternoException{
        this.viagem.atualizar(v);
    }
    
}
