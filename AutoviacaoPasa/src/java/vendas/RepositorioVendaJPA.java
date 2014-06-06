/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendas;

import index.ErroInternoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import viagens.Viagem;
import viagens.ViagemInexistenteException;

/**
 *
 * @author Sabrina Moreira
 */
@Stateless
public class RepositorioVendaJPA implements RepositorioVenda {

    private EntityManager em;

    public RepositorioVendaJPA() {
        EntityManagerFactory f = Persistence.createEntityManagerFactory("AutoviacaoPasaPU");
        this.em = f.createEntityManager();
    }

    public void adicionar(Venda ven) throws ErroInternoException {
        try {
            this.em.persist(ven);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }

    }

    /*public void remover(long codigo) throws ErroInternoException, VendaInexistenteException {

        Venda ven = buscar(codigo);//buscar esta fora do try  para não prender a exceçao
        try {

            this.em.remove(ven);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }

    }

    public void atualizar(Venda ven) throws ErroInternoException, VendaInexistenteException {

        buscar(ven.getCodigo());// não precisa do lançar o erro inexistente pois o buscar esta fora do try e ele ja faz isso
        try {
            this.em.merge(ven);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }*/

    public Venda buscarVenda(long codigo) throws ErroInternoException, VendaInexistenteException {
        try {
            Venda v = this.em.find(Venda.class, codigo);
            if (v == null) {
                throw new VendaInexistenteException();
            }
            return v;
        } catch (Exception e) {
            throw new ErroInternoException(e);

        }
    }

    public List<Venda> vendasPorViagem(long id_viagem) throws ErroInternoException {
        try {
            TypedQuery<Venda> query = this.em.createQuery("SELECT v FROM Venda v WHERE v.id_viagem = :id_viagem ", Venda.class);
            query.setParameter("id_viagem", id_viagem);
            return query.getResultList();
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }
}
