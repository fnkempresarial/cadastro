/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.entidade.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.conexao.Conecta;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author frank
 */
public class CadastroDAO {
    
    //Inserindo dentro do banco de dados
    public int insert(Cadastro cad) throws SQLException{
        
        String sql = "Insert into cadastro(NOME_PRODUTO, DESCRICAO) values (?, ?);";
        int i = 0;
        try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, cad.getNome_produto());
            instrucao.setString(2,cad.getDescricao());
            i = instrucao.executeUpdate();
            
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }    
        return i;
    }
    
    //Testando o método de inserção, inserindo o valor através dele.    
        public void teste_insert() throws SQLException{
        Cadastro cad = new Cadastro();
        cad.setNome_produto("Loratadina");
        cad.setDescricao("Para Alergia");
        
        CadastroDAO CDAO = new CadastroDAO();
        CDAO.insert(cad);        
    }
    
    //Buscando valores no banco de dados
    public ArrayList<Cadastro> RetornaItem() throws SQLException{           
            String sql = "SELECT ID, NOME_PRODUTO, DESCRICAO FROM CADASTRO";
            try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
           
            ResultSet rs = instrucao.executeQuery();
            ArrayList<Cadastro> tabela = new ArrayList<>();
            
            while(rs.next()){
            Cadastro cad = new Cadastro();
            cad.setId(rs.getInt("ID"));
            cad.setNome_produto(rs.getString("NOME_PRODUTO"));
            cad.setDescricao(rs.getString("DESCRICAO"));
            tabela.add(cad);
            }
            return tabela;
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "TROLHA " + ex);
            return null;
            }        
        }
        
        //Buscando Um item especifico dentro do banco de dados
    public  Cadastro RetornaProduto(String nomeCadastro) throws SQLException{           
            String sql = "SELECT ID, NOME_PRODUTO, DESCRICAO FROM CADASTRO WHERE NOME_PRODUTO = ? ";
            try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, nomeCadastro);
            ResultSet rs = instrucao.executeQuery();            
            Cadastro cad = new Cadastro();

            if(rs.first()){                       
            cad.setId(rs.getInt("ID"));
            cad.setNome_produto(rs.getString("NOME_PRODUTO"));
            cad.setDescricao(rs.getString("DESCRICAO"));
            return cad;
            }
            return cad;
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "TROLHA " + ex);
            return null;
            }        
        }
    
    
    
        //Testando o retorno de itens do banco de dados.
        public void teste_unitario_RetornaItem() throws SQLException{
            ArrayList<Cadastro> tabela = new ArrayList<>();
            CadastroDAO CDAO = new CadastroDAO();
            tabela = CDAO.RetornaItem();
            for(Cadastro rs: tabela){
                JOptionPane.showMessageDialog(null, "ID: "+rs.getId()+
                "\nNome Produto: "+rs.getNome_produto() + "\nDescrição: " + rs.getDescricao());
            }
        }
        
        //Método para atualização de dados.
    public boolean update(Cadastro cad) throws SQLException{            
            String sql = "UPDATE  CADASTRO " +
                         "SET NOME_PRODUTO = ?, DESCRICAO = ? " +
                         "WHERE ID = ?";           
            try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setString(1, cad.getNome_produto());
            instrucao.setString(2, cad.getDescricao());
            instrucao.setInt(3, cad.getId());            
            int i = instrucao.executeUpdate();            
            if (i ==1 ){
                JOptionPane.showMessageDialog(null, "Nome Produto ou Descrição Atualizados");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Não encontrado");
                return false;
            }           
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"TROLHA " + ex.getMessage());
            return false;
        }   }
        
        //Teste de execução do update.
        public void teste_unitario_update() throws SQLException{            
            Cadastro cad = new Cadastro();
            cad.setNome_produto("Trombolona");
            cad.setDescricao("Pode provocar males a saúde como ?Alzeimer?");
            cad.setId(1);            
            CadastroDAO CDAO = new CadastroDAO();
            CDAO.update(cad);   
        }      
        
        //Método para deleção no banco de dados.
    public void delete(Cadastro cad) throws SQLException{
            String sql = "DELETE FROM CADASTRO WHERE ID = ?";
            try{
            Connection conexao = Conecta.getConnection();
            PreparedStatement instrucao = conexao.prepareStatement(sql);
            instrucao.setInt(1, cad.getId());
            int i = instrucao.executeUpdate();
            if (i ==1 ){
                JOptionPane.showMessageDialog(null, "Produto Deletado");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }           
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"TROLHA " + ex.getMessage());
        }            
            }
        
        public void teste_unitario_delete() throws SQLException{
            Cadastro cad = new Cadastro();
            cad.setNome_produto("DICLOFENACO");
            CadastroDAO CDAO = new CadastroDAO();
            CDAO.delete(cad);
        }
                                                                                            
    public static void main(String args []) throws SQLException{
        CadastroDAO CDAO = new CadastroDAO();
        CDAO.teste_unitario_delete();
    }
    
}
