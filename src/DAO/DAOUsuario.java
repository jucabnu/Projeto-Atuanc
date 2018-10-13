/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Usuario;
import static Principal.Conexao.getConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Juliano
 */
//public class DAOUsuario implements DAO.Interfaces.DAOUsuarioInt{
public class DAOUsuario{

    public static boolean isAdm(Usuario usu){
        return (usu.getTipusu() == 1);
    }
    
    public static boolean duplicado(String u, String e){
        
        ArrayList<Usuario> listaUsuario = DAO.DAOUsuario.getUsuarios();
            for(Usuario us : listaUsuario){
                if(us.getLogusu().equals(u) || us.getEmausu().equals(e)){
                    return true;                        
                }
            }
            return false;
    }

    public static boolean valida(String u, String p){
        
        //parte da criptografia
        String senha = criptografa(p);
        
        DTO.Usuario us = getUsuarioPeloLogin(u);
        if(us != null){
            if(us.getPasusu().equals(senha + "")){
                return true;
            }
        }
        return false;                
    }
    
    public static String criptografa(String senha){
		try{
		 MessageDigest digest = MessageDigest.getInstance("MD5");
		               digest.update(senha.getBytes());
		 BASE64Encoder encoder = new BASE64Encoder();
		        return encoder.encode(digest.digest());
		}catch(NoSuchAlgorithmException ns){
			ns.printStackTrace();
		}
		return senha + "";
	}
    
    public static void inserir(Usuario usuario){
        try {
            Connection con = getConnection();            
            String sql = "insert into E001USU(nomusu,emausu,logusu,pasusu,tipusu) "
                    + "values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNomusu());
            ps.setString(2, usuario.getEmausu());
            ps.setString(3, usuario.getLogusu());
            ps.setString(4, criptografa(usuario.getPasusu()));
            ps.setInt(5, usuario.getTipusu());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deletar(int codusu){
    try{
            Connection con = getConnection();
            String sql = "delete from E001USU where codusu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codusu);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void atualizar(Usuario usuario){
     try {
            Connection con = getConnection();
            String sql = "update e001usu set "
                    + "nomusu = ?, "
                    + "emausu = ?, "
                    + "logusu = ?, "
                    + "pasusu = ?, "
                    + "tipusu = ?  "
                    + "where codusu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNomusu());  
            ps.setString(2, usuario.getEmausu());  
            ps.setString(3, usuario.getLogusu());  
            ps.setString(4, usuario.getPasusu());
            ps.setInt(5, usuario.getTipusu());
            ps.setInt(6, usuario.getCodusu());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static ArrayList getUsuarioPorCampo(String valor, String campo) {

        ArrayList<Usuario> usuarios = new ArrayList();
        
        try {
            Connection con = getConnection();
            String busca = "%" + valor + "%";
            String sql = "select * from e001usu where ? like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, campo);
            ps.setString(2, busca);
            ResultSet rs = ps.executeQuery();
            //System.out.println("select * from e001usu where " + campo + " like " + busca);
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setCodusu(rs.getInt(1));
                usu.setNomusu(rs.getString(2));
                usu.setEmausu(rs.getString(3));
                usu.setLogusu(rs.getString(4));
                usu.setPasusu(rs.getString(5));
                usu.setTipusu(rs.getInt(6));
                usuarios.add(usu);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("chegou aqui, retornou o array de usuarios");        
        //System.out.println("LEN: " + usuarios.size());
        return usuarios;  
    }
    
    public static ArrayList getUsuarioPorNome(String nome){

        ArrayList<Usuario> usuarios = new ArrayList();
        
        try {
            Connection con = getConnection();
            String busca = "%" + nome + "%";
            String sql = "select * from e001usu where nomusu like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, busca);            
            ResultSet rs = ps.executeQuery();
            // System.out.println("select * from e001usu where nomusu like " + busca);
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setCodusu(rs.getInt(1));
                usu.setNomusu(rs.getString(2));
                usu.setEmausu(rs.getString(3));
                usu.setLogusu(rs.getString(4));
                usu.setPasusu(rs.getString(5));
                usu.setTipusu(rs.getInt(6));
                usuarios.add(usu);
            }
             }catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("chegou aqui, retornou o array de usuarios");        
        //System.out.println("LEN: " + usuarios.size());
        return usuarios;  
    }
    
    public static Usuario getUsuarioPeloCod(int codusu){
    
        Usuario usu = null;
        try {
            Connection con = getConnection();
            String sql = "select * from e001usu where CodUsu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codusu);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                usu = new Usuario(
                        codusu,
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6));
            }
                //System.out.println("criou o usu");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(usu);        
        return usu;
        
    }
    
    public static Usuario getUsuarioPeloLogin(String logusu){
    
        Usuario usu = null;
        try {
            Connection con = getConnection();
            String sql = "select * from e001usu where logusu = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, logusu);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                usu = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6));
            }
                //System.out.println("criou o usu");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
        
    }
    
    public static ArrayList<Usuario> getUsuarios(){
    
        ArrayList<Usuario> usuarios = new ArrayList();
        
         try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from e001usu");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setCodusu(rs.getInt(1));
                usu.setNomusu(rs.getString(2));
                usu.setEmausu(rs.getString(3));
                usu.setLogusu(rs.getString(4));
                usu.setPasusu(rs.getString(5));
                usu.setTipusu(rs.getInt(6));
                usuarios.add(usu);
            }
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
         return usuarios;
    }
    
}
