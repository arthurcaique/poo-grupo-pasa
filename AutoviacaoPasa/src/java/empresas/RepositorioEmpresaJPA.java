/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresas;

import index.ErroInternoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Polyana
 */
@Stateless
public class RepositorioEmpresaJPA implements RepositorioEmpresa{
    
    @PersistenceContext
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
        Empresa ep = buscarEmpresa(id_empresa);
        try {
            this.em.remove(ep);
        }
        catch (Exception e){
            throw new ErroInternoException(e);
            
        }
    }
    @Override
    public void atualizar(Empresa ep) throws ErroInternoException, EmpresaInexistenteException {
        
      
        buscarEmpresa(ep.getId_empresa());
        try{
        this.em.merge(ep);
        }
        catch (Exception e){
        throw new ErroInternoException(e);
        }
    }
        
       
    @Override
    public Empresa buscarEmpresa(long id_empresa) throws ErroInternoException, EmpresaInexistenteException {
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
       public List<Empresa> listaEmpresa () throws ErroInternoException{
         
        try{
        TypedQuery <Empresa> listaEmpresa = this.em.createQuery("SELECT e FROM Empresa e", Empresa.class);    
        return listaEmpresa.getResultList();
        }
       catch(Exception e){
          throw new ErroInternoException(e);
       }
}
}
