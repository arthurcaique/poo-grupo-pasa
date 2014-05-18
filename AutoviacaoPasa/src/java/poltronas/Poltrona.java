/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poltronas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Arthur
 */
@Entity
public class Poltrona implements Serializable{
    private long id_poltrona;
    private int numero_poltrona;
    
    public Poltrona(){
        
    }
    
    public Poltrona(long id_poltrona, int numero_poltrona){
        this.id_poltrona = id_poltrona;
        this.numero_poltrona = numero_poltrona;
    }
    
    @Id
    public long getId_poltrona() {
        return id_poltrona;
    }

    public void setId_poltrona(long id_poltrona) {
        this.id_poltrona = id_poltrona;
    }
    
    @Column(unique = true)
    public int getNumero_poltrona() {
        return numero_poltrona;
    }

    public void setNumero_poltrona(int numero_poltrona) {
        this.numero_poltrona = numero_poltrona;
    }
    
}
