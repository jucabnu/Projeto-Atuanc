/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Juliano
 */
public class Motivo {
    
    private int codmot;
    private String desmot;

    public Motivo() {
    }

    public Motivo(int codmot, String desmot) {
        this.codmot = codmot;
        this.desmot = desmot;
    }

    public int getCodmot() {
        return codmot;
    }

    public void setCodmot(int codmot) {
        this.codmot = codmot;
    }

    public String getDesmot() {
        return desmot;
    }

    public void setDesmot(String desmot) {
        this.desmot = desmot;
    }
    
}
