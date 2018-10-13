/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Rnc;
import DTO.RncSintetico;
import static Principal.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliano
 */
public class DAORnc {
    
    public static void inserir(Rnc rnc){
        try {
            Connection con = getConnection();            
            String sql = "insert into E001RNC (CodUsu,DatReg,DatIni,DatAlt,AltUsu,"
                    + "ResFim,ConFim,IdeCau,OriCau,CliFor,ProSer,CodSet,QtdRnc,"
                    + "NumNfe,NumFal,CodMot,LabInd,DisInd,ValInd,AreInd,ResInd) " //,ResInd﻿) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // 21 parâmetros
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rnc.getCodusu());            
            ps.setTimestamp(2, rnc.getDatreg());
            ps.setTimestamp(3, rnc.getDatini());
            ps.setTimestamp(4, rnc.getDatalt());
            ps.setInt(5, rnc.getAltusu());
            ps.setString(6, rnc.getResfim());
            ps.setInt(7, rnc.getSituacao());
            ps.setString(8, rnc.getIdecau());
            ps.setString(9, rnc.getOricau());
            ps.setString(10, rnc.getClifor());
            ps.setString(11, rnc.getProser());
            ps.setInt(12, rnc.getCodset());
            ps.setFloat(13, rnc.getQtdrnc());
            ps.setInt(14, rnc.getNumnfe());
            ps.setString(15, rnc.getNumfal());
            ps.setInt(16, rnc.getCodmot());
            ps.setBoolean(17, rnc.isLabind());
            ps.setString(18, rnc.getDisind());
            ps.setFloat(19, rnc.getValind());
            ps.setString(20, rnc.getAreind());
            ps.setString(21, rnc.getResind()); 
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deletar(int numrnc){
    try{
            Connection con = getConnection();
            String sql = "delete from E001rnc where numrnc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numrnc);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void inserirDataFim(Rnc rnc){
    try {
            Connection con = getConnection();
            String sql = "update e001rnc set "                                                           
                    + "DatFim = ? "
                    + "where numrnc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                System.out.println("sql: " + sql);
            ps.setTimestamp(1, (Timestamp) rnc.getDatfim());
            ps.setInt(2, rnc.getNumrnc());
            System.out.println("ps: " + ps);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizar(Rnc rnc){
     try {
            Connection con = getConnection();
            String sql = "update e001rnc set "                    
                    //+ "CodUsu = ?, "
                    //+ "DatReg = ?, "
                    //+ "DatIni = ?, "
                    + "DatAlt = ?, "
                    + "AltUsu = ?, "
                    + "ResFim = ?, "
                  //+ "DatFim = ?, "
                    + "ConFim = ?, "
                    + "IdeCau = ?, "
                    + "OriCau = ?, "
                    + "CliFor = ?, "
                    + "ProSer = ?, "
                    + "CodSet = ?, "
                    + "QtdRnc = ?, "
                    + "NumNfe = ?, "
                    + "NumFal = ?, "
                    + "CodMot = ?, "
                    + "LabInd = ?, "
                    + "DisInd = ?, "
                    + "ValInd = ?, "
                    + "AreInd = ?, "
                    + "ResInd = ? "
                    + "where numrnc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
                System.out.println("sql: " + sql);
            //ps.setInt(1, rnc.getCodusu());
            //ps.setString(1, rnc.getDatreg());
            //ps.setString(2, rnc.getDatini());
            ps.setTimestamp(1, (Timestamp) rnc.getDatalt());
            ps.setInt(2, rnc.getAltusu());
            ps.setString(3, rnc.getResfim());
            //ps.setTimestamp(6, (Timestamp) rnc.getDatfim()); //data fim
            //ps.setTimestamp(6, (Timestamp) NULL); //data fim
            ps.setInt(4, rnc.getSituacao());
            ps.setString(5, rnc.getIdecau());
            ps.setString(6, rnc.getOricau());
            ps.setString(7, rnc.getClifor());
            ps.setString(8, rnc.getProser());
            ps.setInt(9, rnc.getCodset());
            ps.setFloat(10, rnc.getQtdrnc());
            ps.setInt(11, rnc.getNumnfe());
            ps.setString(12, rnc.getNumfal());
            ps.setInt(13, rnc.getCodmot());
            ps.setBoolean(14, rnc.isLabind());
            ps.setString(15, rnc.getDisind());
            ps.setFloat(16, rnc.getValind());
            ps.setString(17, rnc.getAreind());
            ps.setString(18, rnc.getResind());
            ps.setInt(19, rnc.getNumrnc());
            System.out.println("ps: " + ps);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static ArrayList getRncPorCampo(String valor, String campo) {

        ArrayList<Rnc> rncs = new ArrayList();
        
        try {
            Connection con = getConnection();
            String busca = "%" + valor + "%";
            System.out.println("busca concatenada: " + busca);
            String prep = "select * from e001rnc where " + campo + " like ";
            String sql = prep + " ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busca);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps);
            
            while(rs.next()){
                Rnc rnc = new Rnc();
                rnc.setNumrnc(rs.getInt(1));
                rnc.setCodusu(rs.getInt(2));
                rnc.setDatreg(rs.getTimestamp(3));
                rnc.setDatini(rs.getTimestamp(4));
                rnc.setDatalt(rs.getTimestamp(5));
                rnc.setAltusu(rs.getInt(6));
                rnc.setResfim(rs.getString(7));
                rnc.setDatfim(rs.getTimestamp(8));
                rnc.setSituacao(rs.getInt(9));
                rnc.setIdecau(rs.getString(10));
                rnc.setOricau(rs.getString(11));
                rnc.setClifor(rs.getString(12));
                rnc.setProser(rs.getString(13));
                rnc.setCodset(rs.getInt(14));
                rnc.setQtdrnc(rs.getFloat(15));
                rnc.setNumnfe(rs.getInt(16));
                rnc.setNumfal(rs.getString(17));
                rnc.setCodmot(rs.getInt(18));
                rnc.setLabind(rs.getBoolean(19));
                rnc.setDisind(rs.getString(20));
                rnc.setValind(rs.getFloat(21));
                rnc.setAreind(rs.getString(22));
                rnc.setResind(rs.getString(23));
                rncs.add(rnc);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return rncs;  
    }
    
    public static Rnc getRncPeloNum(int numrnc){
    
        Rnc rnc = null;
        try {
            Connection con = getConnection();
            String sql = "select * from e001rnc where numrnc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numrnc);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                rnc = new Rnc(
                        numrnc,                                        
                        rs.getInt(2),
                        rs.getTimestamp(3),
                        rs.getTimestamp(4),
                        rs.getTimestamp(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getTimestamp(8),
                        rs.getInt(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getInt(14),
                        rs.getFloat(15),
                        rs.getInt(16),
                        rs.getString(17),
                        rs.getInt(18),
                        rs.getBoolean(19),
                        rs.getString(20),
                        rs.getFloat(21),
                        rs.getString(22),
                        rs.getString(23));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rnc;

        
    }
    
    public static ArrayList<Rnc> getRncs(){
    
        ArrayList<Rnc> rncs = new ArrayList();
        
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from e001rnc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rnc rnc = new Rnc();
                rnc.setNumrnc(rs.getInt(1));
                rnc.setCodusu(rs.getInt(2));
                rnc.setDatreg(rs.getTimestamp(3));
                rnc.setDatini(rs.getTimestamp(4));
                rnc.setDatalt(rs.getTimestamp(5));
                rnc.setAltusu(rs.getInt(6));
                rnc.setResfim(rs.getString(7));
                rnc.setDatfim(rs.getTimestamp(8));
                rnc.setSituacao(rs.getInt(9));
                rnc.setIdecau(rs.getString(10));
                rnc.setOricau(rs.getString(11));
                rnc.setClifor(rs.getString(12));
                rnc.setProser(rs.getString(13));
                rnc.setCodset(rs.getInt(14));
                rnc.setQtdrnc(rs.getFloat(15));
                rnc.setNumnfe(rs.getInt(16));
                rnc.setNumfal(rs.getString(17));
                rnc.setCodmot(rs.getInt(18));
                rnc.setLabind(rs.getBoolean(19));
                rnc.setDisind(rs.getString(20));
                rnc.setValind(rs.getFloat(21));
                rnc.setAreind(rs.getString(22));
                rnc.setResind(rs.getString(23));
                rncs.add(rnc);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rncs;
    }    
    
    public static ArrayList<RncSintetico> getRncsSintetico(){
    
        ArrayList<RncSintetico> rncs = new ArrayList();
        
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from e001rnc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RncSintetico rnc = new RncSintetico();
                rnc.setNumrnc(rs.getInt(1));
                rnc.setCodusu(rs.getInt(2));
                rnc.setDatreg(rs.getTimestamp(3));
                rnc.setDatini(rs.getTimestamp(4));
                rnc.setDatalt(rs.getTimestamp(5));
                rnc.setAltusu(rs.getInt(6));
                rnc.setResfim(rs.getString(7));
                rnc.setDatfim(rs.getTimestamp(8));
                rnc.setSituacao(rs.getInt(9));
                rnc.setIdecau(rs.getString(10));
                rnc.setOricau(rs.getString(11));
                rnc.setClifor(rs.getString(12));
                rnc.setProser(rs.getString(13));
                rnc.setCodset(rs.getInt(14));
                rnc.setQtdrnc(rs.getFloat(15));
                rnc.setNumnfe(rs.getInt(16));
                rnc.setNumfal(rs.getString(17));
                rnc.setCodmot(rs.getInt(18));
                rnc.setLabind(rs.getBoolean(19));
                rnc.setDisind(rs.getString(20));
                rnc.setValind(rs.getFloat(21));
                rnc.setAreind(rs.getString(22));
                rnc.setResind(rs.getString(23));
                rncs.add(rnc);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Rnc.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rncs;
    }    
    
}
