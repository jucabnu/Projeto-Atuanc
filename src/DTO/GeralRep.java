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
public class GeralRep {
    
    private String setor;
    private int quantidade;
    private int percentual;
    
    public GeralRep(){
    }
    
    public GeralRep(String setor, int quantidade, int percentual){
        this.setor = setor;
        this.quantidade = quantidade;
        this.percentual = percentual;
    }

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }
    
    public void setSetor(String setor){
        this.setor = setor;
    }
    
    public String getSetor(){
        return this.setor;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    
    
}
