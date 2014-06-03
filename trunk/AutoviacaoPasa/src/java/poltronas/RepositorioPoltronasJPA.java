/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Arthur
 */
public class RepositorioPoltronasJPA implements RepositorioPoltronas{
    
    private EntityManager em;
    
    RepositorioPoltronasJPA(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoviacaoPasaPU");
        this.em = emf.createEntityManager();
    }
    
    
    @Override
    public void adicionar(Poltrona p) throws ErroInternoException, PoltronaInexistenteException, PoltronaIndisponivelException {
        try{
        this.em.persist(p);
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
    }

    @Override
    public Poltrona buscar(long id_poltrona) throws ErroInternoException, PoltronaInexistenteException {
        try{
            Poltrona p = this.em.find(Poltrona.class, id_poltrona);
            if(p == null){
                throw new PoltronaInexistenteException();
            }
            return p;
        }
        catch(Exception e){
            throw new ErroInternoException(e);
        }
        
    }

    @Override
    public List<Poltrona> listar(long id_viagem) throws ErroInternoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
