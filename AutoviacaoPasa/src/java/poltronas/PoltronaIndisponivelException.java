/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poltronas;

/**
 *
 * @author Arthur
 */
public class PoltronaIndisponivelException extends Exception {
    public PoltronaIndisponivelException(){
        super("Poltrona indisponível");
    }
}
