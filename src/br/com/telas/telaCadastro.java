/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.DAO.CadastroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.entidade.Cadastro;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frank
 */
public final class telaCadastro extends javax.swing.JInternalFrame {

    Cadastro cad;
    
    
    /**
     * Creates new form Cadastro
     */
    public telaCadastro() {
        initComponents();
        populaTabela();
    }

    
    public void populaTabela(){
        
        DefaultTableModel modelo = (DefaultTableModel) jTabela.getModel();        
        CadastroDAO leituraBanco = new CadastroDAO();
        modelo.setRowCount(0);
        try{
        ArrayList<Cadastro> itens =  leituraBanco.RetornaItem();
         
        for(Cadastro cadx : itens){
            
           modelo.addRow(new Object[] {           
           cadx.getId(),
           cadx.getNome_produto(),
           cadx.getDescricao()
           });     
            
        }
        
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProduto = new javax.swing.JLabel();
        jCampoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCampoDescricao = new javax.swing.JTextField();
        jBotaoIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jbotaoAlterar = new javax.swing.JButton();
        jbotaoApagar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro");

        jLabelProduto.setText("Nome do Produto:");

        jLabel1.setText("Descrição:");

        jBotaoIncluir.setText("Incluir");
        jBotaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoIncluirActionPerformed(evt);
            }
        });

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Descrição"
            }
        ));
        jTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabela);

        jbotaoAlterar.setText("Alterar");
        jbotaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotaoAlterarActionPerformed(evt);
            }
        });

        jbotaoApagar.setText("Apagar");
        jbotaoApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotaoApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelProduto)
                            .addComponent(jCampoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBotaoIncluir))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbotaoAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbotaoApagar)
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduto)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCampoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotaoIncluir)
                    .addComponent(jbotaoAlterar)
                    .addComponent(jbotaoApagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoIncluirActionPerformed
      CadastroDAO cadastrabanco = new CadastroDAO();
      Cadastro cadastro = new Cadastro();
        if( jCampoProduto.getText().equals("") ){
        JOptionPane.showMessageDialog(rootPane, "Nome Produto Vazio");
    }else{
       cadastro.setNome_produto(jCampoProduto.getText());
       cadastro.setDescricao(jCampoDescricao.getText());                   
        try {            
            if (cadastrabanco.insert(cadastro) ==1 ){
                JOptionPane.showMessageDialog(rootPane, "Produto Inserido");
                jCampoProduto.setText("");
                jCampoDescricao.setText("");
                populaTabela();
            } else {
                JOptionPane.showMessageDialog(rootPane, "PAN");
            }
            //     JOptionPane.showMessageDialog(rootPane, cadastro.getNome_produto() +" "+  cadastro.getDescricao());
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(rootPane, "PAN");
        }        
        }       
    }//GEN-LAST:event_jBotaoIncluirActionPerformed

    private void jbotaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotaoAlterarActionPerformed
      
        if (jTabela.getSelectedRow() > -1){
            cad.setNome_produto(jCampoProduto.getText());
            cad.setDescricao(jCampoDescricao.getText());
         CadastroDAO cadastrabanco = new CadastroDAO();   
            try {
                cadastrabanco.update(cad);
                populaTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                
            }             
        }else {
            
            JOptionPane.showMessageDialog(rootPane, "Nenhuma Linha Selecionada");
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jbotaoAlterarActionPerformed

    private void jTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabelaMouseClicked
            cad = new Cadastro();
         if (jTabela.getSelectedRow() > -1){
            cad.setId((Integer) jTabela.getValueAt(jTabela.getSelectedRow(),0));
            jCampoProduto.setText((String) jTabela.getValueAt(jTabela.getSelectedRow(),1));
            jCampoDescricao.setText((String) jTabela.getValueAt(jTabela.getSelectedRow(),2));
    
        }
        
        
    }//GEN-LAST:event_jTabelaMouseClicked

    private void jbotaoApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotaoApagarActionPerformed
        
        if (jTabela.getSelectedRow() > -1){
            cad.setNome_produto(jCampoProduto.getText());
            cad.setDescricao(jCampoDescricao.getText());
         CadastroDAO cadastrabanco = new CadastroDAO();   
            try {
                cadastrabanco.delete(cad);
                populaTabela();
                jCampoProduto.setText("");
                jCampoDescricao.setText("");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                
            }             
        }else {
            
            JOptionPane.showMessageDialog(rootPane, "Nenhuma Linha Selecionada");
            
        }
        
        
    }//GEN-LAST:event_jbotaoApagarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoIncluir;
    private javax.swing.JTextField jCampoDescricao;
    private javax.swing.JTextField jCampoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JButton jbotaoAlterar;
    private javax.swing.JButton jbotaoApagar;
    // End of variables declaration//GEN-END:variables
}