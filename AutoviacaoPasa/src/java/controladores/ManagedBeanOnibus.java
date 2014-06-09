/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import index.ErroInternoException;
import index.Fachada;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import onibus.Onibus;
import onibus.OnibusExistenteException;

/**
 *
 * @author Arthur
 */
@ManagedBean
public class ManagedBeanOnibus {

    @EJB
    private Fachada fachada;
    private Onibus onibus;

    public ManagedBeanOnibus() {
    }

    public String cadastrarOnibus() throws OnibusExistenteException, ErroInternoException {
        try {
            fachada.cadastrar(onibus);
            return "index.xhtml";
        } catch (Exception e) {
            //throw new ErroInternoException(e);
            return null;
        }
    }
}
