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
public class RncAnalitico {
    
    private int numrnc;
    private String nomusu_ger;
    private String nomusu_alt;
    
  //private String datreg;
    //private String datini;
    //private String datalt;
    //private String datfim;
    
    private String datreg;
    private String datini;
    private String datalt;
    private String datfim;
    
    private String resfim;    
    private String situacao;
    private String idecau;
    private String oricau;
    private String clifor;
    private String proser;
    private String nomset;
    private String numfal;
    private String desmot;
    private String labind;
    private String disind;
    
    private String areind;
    private String resind;

    private float valind;
    private float qtdrnc;
    private int numnfe;
    
    public RncAnalitico() {
    }

    public RncAnalitico(int numrnc, String nomusu_ger, String datreg, 
            String datini, String datalt, String datfim, String nomusu_alt, 
            String resfim, String situacao, String idecau, String oricau, 
            String clifor, String proser, String nomset, float qtdrnc, int numnfe, 
            String numfal, String desmot, String labind, String disind, float valind, 
            String areind, String resind) {
        this.numrnc = numrnc;
        this.nomusu_ger = nomusu_ger;
        this.datreg = datreg;
        this.datini = datini;
        this.datalt = datalt;
        this.datfim = datfim;
        this.nomusu_alt = nomusu_alt;
        this.resfim = resfim;
        this.situacao = situacao;
        this.idecau = idecau;
        this.oricau = oricau;
        this.clifor = clifor;
        this.proser = proser;
        this.nomset = nomset;
        this.qtdrnc = qtdrnc;
        this.numnfe = numnfe;
        this.numfal = numfal;
        this.desmot = desmot;
        this.labind = labind;
        this.disind = disind;
        this.valind = valind;
        this.areind = areind;
        this.resind = resind;
    }

    @Override
    public String toString() {
        return "RncRep{" + "numrnc=" + numrnc + ", nomusu_ger=" + nomusu_ger + ", datreg=" + datreg + ", datini=" + datini + ", datalt=" + datalt + ", datfim=" + datfim + ", nomusu_alt=" + nomusu_alt + ", resfim=" + resfim + ", situacao=" + situacao + ", idecau=" + idecau + ", oricau=" + oricau + ", clifor=" + clifor + ", proser=" + proser + ", nomset=" + nomset + ", qtdrnc=" + qtdrnc + ", numnfe=" + numnfe + ", numfal=" + numfal + ", desmot=" + desmot + ", labind=" + labind + ", disind=" + disind + ", valind=" + valind + ", areind=" + areind + ", resind=" + resind + '}';
    }
    
    

    public int getNumrnc() {
        return numrnc;
    }

    public void setNumrnc(int numrnc) {
        this.numrnc = numrnc;
    }

    public String getNomusu_ger() {
        return nomusu_ger;
    }

    public void setNomusu_ger(String nomusu_ger) {
        this.nomusu_ger = nomusu_ger;
    }

    public String getDatreg() {
        return datreg;
    }

    public void setDatreg(String datreg) {
        this.datreg = datreg;
    }

    public String getDatini() {
        return datini;
    }

    public void setDatini(String datini) {
        this.datini = datini;
    }

    public String getDatalt() {
        return datalt;
    }

    public void setDatalt(String datalt) {
        this.datalt = datalt;
    }

    public String getDatfim() {
        return datfim;
    }

    public void setDatfim(String datfim) {
        this.datfim = datfim;
    }

    public String getNomusu_alt() {
        return nomusu_alt;
    }

    public void setNomusu_alt(String nomusu_alt) {
        this.nomusu_alt = nomusu_alt;
    }

    public String getResfim() {
        return resfim;
    }

    public void setResfim(String resfim) {
        this.resfim = resfim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public String getNomset() {
        return nomset;
    }

    public void setNomset(String nomset) {
        this.nomset = nomset;
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

    public String getDesmot() {
        return desmot;
    }

    public void setDesmot(String desmot) {
        this.desmot = desmot;
    }

    public String getLabind() {
        return labind;
    }

    public void setLabind(String labind) {
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
