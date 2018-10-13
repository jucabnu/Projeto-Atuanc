/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Principal.Datas;
import java.sql.Timestamp;

/**
 *
 * @author Juliano
 */
public class RncSintetico {
    
    private int numrnc;
    private int codusu;    
    
    //private String datreg;
    //private String datini;
    //private String datalt;
    //private String datfim;
    
    private Timestamp datreg;
    private Timestamp datini;
    private Timestamp datalt;
    private Timestamp datfim;
        
    private int altusu;
    private String resfim;    
    private int situacao; // Conclusão Final (Procedente / Improcedente / Em andamento)
    private String idecau;
    private String oricau;
    private  String clifor;
    private  String proser;
    private int codset;
    private  float qtdrnc;
    private int numnfe;
    private String numfal;
    private int codmot;
    private boolean labind;
    private String disind;
    private float valind;
    private String areind;
    private String resind;

    public RncSintetico() {
    }

    public RncSintetico(int numrnc, int codusu, Timestamp datreg, 
            Timestamp datini, Timestamp datalt, int altusu, String resfim, 
            Timestamp datfim, int situacao, String idecau, String oricau, 
            String clifor, String proser, int codset, float qtdrnc, int numnfe, 
            String numfal, int codmot, boolean labind, String disind, 
            float valind, String areind, String resind) {
        this.numrnc = numrnc;
        this.codusu = codusu;
        this.datreg = datreg;
        this.datini = datini;
        this.datalt = datalt;
        this.altusu = altusu;
        this.resfim = resfim;
        this.datfim = datfim;
        this.situacao = situacao;
        this.idecau = idecau;
        this.oricau = oricau;
        this.clifor = clifor;
        this.proser = proser;
        this.codset = codset;
        this.qtdrnc = qtdrnc;
        this.numnfe = numnfe;
        this.numfal = numfal;
        this.codmot = codmot;
        this.labind = labind;
        this.disind = disind;
        this.valind = valind;
        this.areind = areind;
        this.resind = resind;
    }

    public int getAltusu() {
        return altusu;
    }

    public void setAltusu(int altusu) {
        this.altusu = altusu;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    
    public int getNumrnc() {
        return numrnc;
    }

    public void setNumrnc(int numrnc) {
        this.numrnc = numrnc;
    }

    public int getCodusu() {
        return codusu;
    }

    public void setCodusu(int codusu) {
        this.codusu = codusu;
    }

    public String getDatreg() {
        return Datas.converteData(datreg);
    }

    public void setDatreg(Timestamp datreg) {
        this.datreg = datreg;
    }

    public String getDatini() {
        return Datas.converteData(datini);
    }

    public void setDatini(Timestamp datini) {
        this.datini = datini;
    }

    public String getDatalt() {
        return Datas.converteData(datalt);
    }

    public void setDatalt(Timestamp datalt) {
        this.datalt = datalt;
    }

    public String getResfim() {
        return resfim;
    }

    public void setResfim(String resfim) {
        this.resfim = resfim;
    }

    public String getDatfim() {
        if(this.datfim == null){
            return "não finalizado";
        }else{
            return Datas.converteData(datfim);
        }
    }

    public void setDatfim(Timestamp datfim) {
        this.datfim = datfim;
    }

    public String getIdecau() {
        return idecau;
    }

    public void setIdecau(String idecau) {
        this.idecau = idecau;
    }

    public String getOricau() {
        return oricau;
    }

    public void setOricau(String oricau) {
        this.oricau = oricau;
    }

    public String getClifor() {
        return clifor;
    }

    public void setClifor(String clifor) {
        this.clifor = clifor;
    }

    public String getProser() {
        return proser;
    }

    public void setProser(String proser) {
        this.proser = proser;
    }

    public int getCodset() {
        return codset;
    }

    public void setCodset(int codset) {
        this.codset = codset;
    }

    public float getQtdrnc() {
        return qtdrnc;
    }

    public void setQtdrnc(float qtdrnc) {
        this.qtdrnc = qtdrnc;
    }

    public int getNumnfe() {
        return numnfe;
    }

    public void setNumnfe(int numnfe) {
        this.numnfe = numnfe;
    }

    public String getNumfal() {
        return numfal;
    }

    public void setNumfal(String numfal) {
        this.numfal = numfal;
    }

    public int getCodmot() {
        return codmot;
    }

    public void setCodmot(int codmot) {
        this.codmot = codmot;
    }

    public boolean isLabind() {
        return labind;
    }

    public void setLabind(boolean labind) {
        this.labind = labind;
    }

    public String getDisind() {
        return disind;
    }

    public void setDisind(String disind) {
        this.disind = disind;
    }

    public float getValind() {
        return valind;
    }

    public void setValind(float valind) {
        this.valind = valind;
    }

    public String getAreind() {
        return areind;
    }

    public void setAreind(String areind) {
        this.areind = areind;
    }

    public String getResind() {
        return resind;
    }

    public void setResind(String resind) {
        this.resind = resind;
    }
    
    
            
    
    
}
