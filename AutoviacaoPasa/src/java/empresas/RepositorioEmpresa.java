/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empresas;

import index.ErroInternoException;
import java.io.Serializable;

/**
 *
 * @author Polyana
 */
public interface RepositorioEmpresa extends Serializable {
    public void adicionar (Empresa ep) throws ErroInternoException;
    public Empresa buscar (long id_empresa) throws ErroInternoException,EmpresaInexistenteException;
    public void atualizar (Empresa ep) throws ErroInternoException, EmpresaInexistenteException;
    public void remover   (long id_empresa) throws ErroInternoException, EmpresaInexistenteException;
    
}
