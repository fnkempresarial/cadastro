/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Proflab02
 */
public class Conecta {
    
 public static Connection getConnection() throws SQLException{
   try{
   Class.forName("com.mysql.jdbc.Driver");
  return  DriverManager.getConnection(
          "jdbc:mysql://localhost/CRUDSIMPLES","etrr","meubanco");
  }catch(ClassNotFoundException e){
     throw new SQLException(e.getMessage());
       }          
}

 public static void main(String [] args){   
  try{
     Connection conexao = Conecta.getConnection();// -> Gera a conexão
        
        if (conexao != null){
            JOptionPane.showMessageDialog(null, "Está conectado");
            //System.out.println("Está conectado");
            conexao.close();
        }
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "TROLHA " + e.getMessage());
       // System.err.println("Deu erro" + e.getMessage());           
                }
    }   }
 
 
