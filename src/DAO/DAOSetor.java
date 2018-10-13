/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Setor;
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
public class DAOSetor {
    
    public static void inserir(Setor setor){
        try {
            Connection con = getConnection();            
            String sql = "insert into E001SET(nomset) "
                    + "values(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, setor.getNomset());            
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deletar(int codset){
    try{
            Connection con = getConnection();
            String sql = "delete from E001set where codset = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codset);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizar(Setor setor){
     try {
            Connection con = getConnection();
            String sql = "update e001set set "
                    + "nomset = ? "
                    + "where codset = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, setor.getNomset());  
            ps.setInt(2, setor.getCodset());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Setor getSetorPorNome(String valor) {

        Setor set = null;
        
        try {
            Connection con = getConnection();            
            String sql = "select codset from e001set where nomset = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, valor);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                set = new Setor(rs.getInt(1), valor);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return set;  
    }
   
    public static ArrayList getSetoresPorNome(String valor) {

        ArrayList<Setor> setores = new ArrayList();
        
        try {
            Connection con = getConnection();
            String busca = "%" + valor + "%";
            String sql = "select * from e001set where nomset like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busca);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Setor s = new Setor();
                s.setCodset(rs.getInt(1));
                s.setNomset(rs.getString(2));
                setores.add(s);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return setores;  
    }
    
    public static Setor getSetorPeloCod(int codset){
    
        Setor s = null;
        try {
            Connection con = getConnection();
            String sql = "select nomset from e001set where Codset = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codset);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                s = new Setor(codset, rs.getString(1));
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public static ArrayList<Setor> getSetores(){
    
        ArrayList<Setor> setores = new ArrayList();
        
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from e001set");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Setor s = new Setor();
                s.setCodset(rs.getInt(1));
                s.setNomset(rs.getString(2));
                setores.add(s);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Setor.class.getName()).log(Level.SEVERE, null, ex);
        }
         return setores;
    }        
}
