/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Motivo;
import static Principal.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juliano
 */
public class DAOMotivo {
    
    public static void inserir(Motivo motivo){
        try {
            Connection con = getConnection();            
            String sql = "insert into E001MOT(desmot) "
                    + "values(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, motivo.getDesmot());            
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deletar(int codmot){
    try{
            Connection con = getConnection();
            String sql = "delete from E001MOT where codmot = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codmot);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizar(Motivo motivo){
     try {
            Connection con = getConnection();
            String sql = "update e001mot set "
                    + "desmot = ? "
                    + "where codmot = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, motivo.getDesmot());  
            ps.setInt(2, motivo.getCodmot());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static ArrayList getMotivosPorDesc(String valor) {

        ArrayList<Motivo> motivos = new ArrayList();
        
        try {
            Connection con = getConnection();
            String busca = "%" + valor + "%";
            String sql = "select * from e001mot where desmot like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busca);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Motivo mot = new Motivo();
                mot.setCodmot(rs.getInt(1));
                mot.setDesmot(rs.getString(2));
                motivos.add(mot);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return motivos;  
    }
    
    public static Motivo getMotivoPorDesc(String valor) {

        Motivo mot = null;
        try {
            Connection con = getConnection();
            String sql = "select codmot from e001mot where desmot = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                mot = new Motivo(rs.getInt(1), valor);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return mot;  
    }
    
    public static Motivo getMotivoPeloCod(int codmot){
    
        Motivo mot = null;
        try {
            Connection con = getConnection();
            String sql = "select * from e001mot where codmot = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codmot);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                mot = new Motivo(codmot, rs.getString(2));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mot;        
    }
    
    public static ArrayList<Motivo> getMotivos(){
    
        ArrayList<Motivo> motivos = new ArrayList();
        
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from e001mot");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Motivo mot = new Motivo();
                mot.setCodmot(rs.getInt(1));
                mot.setDesmot(rs.getString(2));
                motivos.add(mot);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Motivo.class.getName()).log(Level.SEVERE, null, ex);
        }
         return motivos;
    }    
}
