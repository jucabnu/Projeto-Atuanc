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
public class Usuario {
    
    private int codusu;
    private String nomusu;
    private String emausu;
    private String logusu;
    private String pasusu;
    private int tipusu;

    
    public Usuario() {
        /*
        this.codusu = 0;
        this.nomusu = "";
        this.emausu = "";
        this.logusu = "";
        this.pasusu = "";
        this.tipusu = 0;
*/
    }

    public Usuario(int codusu, String nomusu, String emausu, String logusu, String pasusu, int tipusu) {
        this.codusu = codusu;
        this.nomusu = nomusu;
        this.emausu = emausu;
        this.logusu = logusu;
        this.pasusu = pasusu;
        this.tipusu = tipusu;
    }

    public int getCodusu() {
        return codusu;
    }

    public void setCodusu(int codusu) {
        this.codusu = codusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getEmausu() {
        return emausu;
    }

    public void setEmausu(String emausu) {
        this.emausu = emausu;
    }

    public String getLogusu() {
        return logusu;
    }

    public void setLogusu(String logusu) {
        this.logusu = logusu;
    }

    public String getPasusu() {
        return pasusu;
    }

    public void setPasusu(String pasusu) {
        this.pasusu = pasusu;
    }

    public int getTipusu() {
        return tipusu;
    }

    public void setTipusu(int tipusu) {
        this.tipusu = tipusu;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codusu=" + codusu + ", nomusu=" + nomusu + ", emausu=" + emausu + ", logusu=" + logusu + ", pasusu=" + pasusu + ", tipusu=" + tipusu + '}';
    }
    
    
    
}
