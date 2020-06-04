/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.telas;

import br.com.DAO.CadastroDAO;
import br.com.entidade.Cadastro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author frank
 */
public class AtualizaCadastro extends javax.swing.JFrame {
    ArrayList<Cadastro> lista = new ArrayList<>();
    CadastroDAO CDAO = new CadastroDAO();
    Cadastro cad = new Cadastro();
    
    
    /**
     * Creates new form AtualizaCadastro
     * @throws java.sql.SQLException
     */
    public AtualizaCadastro() throws SQLException {
        initComponents();
        this.AtualizaSelecao();
    }

    
    public void AtualizaSelecao() throws SQLException{
         lista = CDAO.RetornaItem();
         jComboSelecao.removeAllItems();
         for(Cadastro luizgustavo : lista){
         jComboSelecao.addItem(luizgustavo.getNome_produto());
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

        jComboSelecao = new javax.swing.JComboBox<>();
        jLabelSelecao = new javax.swing.JLabel();
        jBotaoSelecao = new javax.swing.JButton();
        jLabelProduto = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jCampoProduto = new javax.swing.JTextField();
        jCampoDescricao = new javax.swing.JTextField();
        jBotaoAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboSelecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSelecao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelSelecao.setText("Selecione o Produto:");

        jBotaoSelecao.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jBotaoSelecao.setText("Selecionar");
        jBotaoSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoSelecaoActionPerformed(evt);
            }
        });

        jLabelProduto.setText("Produto:");

        jLabelDescricao.setText("Descricao");

        jBotaoAtualizar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jBotaoAtualizar.setText("Atualizar");
        jBotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBotaoAtualizar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelDescricao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelProduto)
                            .addGap(18, 18, 18)
                            .addComponent(jCampoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelSelecao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addComponent(jComboSelecao, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(33, 33, 33)
                            .addComponent(jBotaoSelecao))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSelecao)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotaoSelecao))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProduto)
                    .addComponent(jCampoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jCampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jBotaoAtualizar)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoSelecaoActionPerformed
                               
        try {
          cad = CDAO.RetornaProduto(jComboSelecao.getItemAt(jComboSelecao.getSelectedIndex()));
          jCampoProduto.setText(cad.getNome_produto());
          jCampoDescricao.setText(cad.getDescricao());
          
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBotaoSelecaoActionPerformed

    private void jBotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoAtualizarActionPerformed
        
           cad.setNome_produto(jCampoProduto.getText());
           cad.setDescricao(jCampoDescricao.getText());
        try {
            CDAO.update(cad);
            jCampoProduto.setText("");
            jCampoDescricao.setText("");
            this.AtualizaSelecao();
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
    }//GEN-LAST:event_jBotaoAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtualizaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AtualizaCadastro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AtualizaCadastro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoAtualizar;
    private javax.swing.JButton jBotaoSelecao;
    private javax.swing.JTextField jCampoDescricao;
    private javax.swing.JTextField jCampoProduto;
    private javax.swing.JComboBox<String> jComboSelecao;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelProduto;
    private javax.swing.JLabel jLabelSelecao;
    // End of variables declaration//GEN-END:variables
}