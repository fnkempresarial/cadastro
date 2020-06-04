/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.conexao.Conecta;
import br.com.entidade.Cadastro;
import br.com.entidade.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author frank
 */
public class UsersDAO {
    
      public  Users AvaliaUsuario(Users user) throws SQLException{           
            String sql = "SELECT ID, NOME, PASS, EMAIL FROM USERS WHERE NOME = ? AND PASS = AES_ENCRYPT(?,'segredo')";
            try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, user.getNome());
            instrucao.setString(2, user.getPass());
            ResultSet rs = instrucao.executeQuery();            
            Users retUser = new Users();

            if(rs.first()){                       
            retUser.setId(rs.getInt("ID"));
            retUser.setNome(rs.getString("NOME"));
            retUser.setEmail(rs.getString("EMAIL"));
            retUser.setPass(rs.getString("PASS"));
            return retUser;
            }
            return null;
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro " + ex);
            return null;
            }        
        }
      
      public static void main (String [] args){
          Users user = new Users();
          Users useret = new Users();
          user.setNome("Franklin");
          user.setEmail("fnkempresarial@gmail.com");
          
          UsersDAO udao = new UsersDAO();
          
          try {
              useret = udao.AvaliaUsuario(user);
              System.out.println(useret);
          } catch (SQLException ex) {
              Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
    
}
