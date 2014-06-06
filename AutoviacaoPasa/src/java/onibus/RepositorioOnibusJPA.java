/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus;

import index.ErroInternoException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Arthur
 */
@Stateless
public class RepositorioOnibusJPA implements RepositorioOnibus {

    private EntityManager em;

    public RepositorioOnibusJPA() {
        this.em = Persistence.createEntityManagerFactory("AutoviacaoPasaPU").createEntityManager();
    }

    public void cadastrar(Onibus onibus) throws ErroInternoException {
        try {
            this.em.persist(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    public void excluir(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
        Onibus onibus = buscarOnibus(id_onibus);
        try {
            this.em.remove(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    public Onibus buscarOnibus(long id_onibus) throws ErroInternoException, OnibusInexistenteException {
        try {
            Onibus onibus = this.em.find(Onibus.class, id_onibus);
            if (onibus == null) {
                throw new OnibusInexistenteException();
            }
            return onibus;
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

    public void editar(Onibus onibus) throws ErroInternoException, OnibusInexistenteException {
        buscarOnibus(onibus.getId_onibus());
        try {
            this.em.merge(onibus);
        } catch (Exception e) {
            throw new ErroInternoException(e);
        }
    }

}
