/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viagens;

import index.ErroInternoException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class RepositorioViagemJPA implements RepositorioViagem{
    
    private EntityManager em;
    
    public RepositorioViagemJPA(){
        EntityManagerFactory f = Persistence.createEntityManagerFactory("AutoviacaoPasaPU");
        this.em = f.createEntityManager();
    }
    
    
    @Override
    public void adicionar(Viagem v) throws ErroInternoException {
        try{
            this.em.persist(v);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    
    }
    
    @Override
    public void removerViagem(long id_viagem) throws ErroInternoException, ViagemInexistenteException {
        
          Viagem v = buscarViagem(id_viagem);//buscar esta fora do try  para não prender a exceçao
        try{
             
              this.em.remove(v);
            }
                 
            
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    
    }
    
    @Override
    public void atualizar(Viagem v) throws ErroInternoException, ViagemInexistenteException {
        
      
        buscarViagem(v.getId_viagem());// não precisa do lançar o erro inexistente pois o buscar esta fora do try e ele ja faz isso
        try{
        this.em.merge(v);
        }
        catch (Exception e){
        throw new ErroInternoException(e);
        }
    }
        
       
    @Override
    public Viagem buscarViagem(long id_viagem) throws ErroInternoException, ViagemInexistenteException {
        try{
            Viagem v = this.em.find(Viagem.class, id_viagem);
            if(v == null){
                throw new ViagemInexistenteException();
            }
            return v;
        }
     
        catch(Exception e){
            throw new ErroInternoException(e);
        
        }
    }
}
