/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

/**
 *
 * @author Arthur
 */
public class PoltronaInexistenteException extends Exception {
    public PoltronaInexistenteException(){
        super ("A poltrona escolhida não existe!");
    }
}
