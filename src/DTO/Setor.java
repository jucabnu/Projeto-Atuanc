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
public class Setor {
    
    private int codset;
    private String nomset;

    public Setor() {
    }
    
    public Setor(int codset, String nomset) {
        this.codset = codset;
        this.nomset = nomset;
    }

    @Override
    public String toString() {
        return "Setor{" + "codset=" + codset + ", nomset=" + nomset + '}';
    }

    public int getCodset() {
        return codset;
    }

    public void setCodset(int codset) {
        this.codset = codset;
    }

    public String getNomset() {
        return nomset;
    }

    public void setNomset(String nomset) {
        this.nomset = nomset;
    }
    
    // teste de comentario no código que precisa ser refatorado
    
}
