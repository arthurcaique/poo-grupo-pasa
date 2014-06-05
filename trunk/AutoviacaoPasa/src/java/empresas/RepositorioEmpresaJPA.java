/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresas;

import index.ErroInternoException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Polyana
 */
@Stateless
public class RepositorioEmpresaJPA implements RepositorioEmpresa{
    private EntityManager em;
    
    public RepositorioEmpresaJPA(){
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("AutoviacaoPasaPu");
        this.em = ef.createEntityManager();
    }
    @Override
    public void adicionar  (Empresa ep) throws ErroInternoException{
        try {
            this.em.persist(ep);
        }
        catch (Exception e){
            throw new ErroInternoException(e);
        }
    }
    @Override
    public void  remover (long id_empresa) throws ErroInternoException,EmpresaInexistenteException{
        Empresa ep = buscar(id_empresa);
        try {
            this.em.remove(ep);
        }
        catch (Exception e){
            throw new ErroInternoException(e);
            
        }
    }
    @Override
    public void atualizar(Empresa ep) throws ErroInternoException, EmpresaInexistenteException {
        
      
        buscar(ep.getId_empresa());
        try{
        this.em.merge(ep);
        }
        catch (Exception e){
        throw new ErroInternoException(e);
        }
    }
        
       
    @Override
    public Empresa buscar(long id_empresa) throws ErroInternoException, EmpresaInexistenteException {
        try{
            Empresa ep = this.em.find(Empresa.class, id_empresa);
            if(ep == null){
                throw new EmpresaInexistenteException();
            }
            return ep;
        }
     
        catch(Exception e){
            throw new ErroInternoException(e);
        
        }
    }
}
