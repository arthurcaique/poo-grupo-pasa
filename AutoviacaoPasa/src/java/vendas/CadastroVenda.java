/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vendas;

import index.ErroInternoException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import viagens.Viagem;

/**
 *
 * @author Arthur
 */
@Stateless
public class CadastroVenda {
    
    @EJB
    private RepositorioVenda venda;
    private List<Viagem> viagem;
    
    public CadastroVenda(){
    }
    
    public void adicionar(Venda venda) throws ErroInternoException{
        this.venda.adicionar(venda);
    }
    
    public Venda buscar(long id) throws ErroInternoException, VendaInexistenteException{
        return this.venda.buscar(id);
    }
    
    public List<Venda> vendasPorViagem(long id_viagem) throws ErroInternoException, VendaInexistenteException{
            List<Venda> venda = new ArrayList<Venda>();
            for (int i = 0; i < this.viagem.size(); i++){
                if (this.viagem.get(i).getId_viagem() == id_viagem){
                    venda.add(buscar(id_viagem));
                }
            }
            return venda;
    }
}
