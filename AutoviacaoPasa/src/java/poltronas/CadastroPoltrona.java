/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

import index.ErroInternoException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
@Stateless
public class CadastroPoltrona {

    @EJB
    private RepositorioPoltronas poltronas;

    public CadastroPoltrona() {

    }

    public void adicionar(Poltrona p) throws ErroInternoException, PoltronaIndisponivelException {
        try {
            Poltrona p2 = this.poltronas.buscarPoltrona(p.getId_poltrona());
            if (p2 != null) {
                throw new PoltronaIndisponivelException();
            }
        } catch (PoltronaInexistenteException e) {
            this.poltronas.adicionar(p);
        }
    }

    public List<Poltrona> listar(long id_viagem) throws ErroInternoException {
        return this.poltronas.listar(id_viagem);
    }

    public Poltrona buscarPoltrona(long id_poltrona) throws ErroInternoException, PoltronaInexistenteException {
        return this.poltronas.buscarPoltrona(id_poltrona);
    }

    public List<Long> poltronasCompradas(Viagem viagem) throws ErroInternoException {
        return this.poltronas.poltronasCompradas(viagem);
    }

}
